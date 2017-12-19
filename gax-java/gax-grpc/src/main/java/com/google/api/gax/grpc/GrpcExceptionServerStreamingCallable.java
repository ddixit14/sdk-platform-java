/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import java.util.Set;
import java.util.concurrent.CancellationException;

/**
 * Transforms all {@code Throwable}s thrown during a call into an instance of {@link ApiException}.
 *
 * <p>Package-private for internal use.
 */
class GrpcExceptionServerStreamingCallable<RequestT, ResponseT>
    extends ServerStreamingCallable<RequestT, ResponseT> {
  private final ServerStreamingCallable<RequestT, ResponseT> inner;
  private final GrpcApiExceptionFactory exceptionFactory;

  public GrpcExceptionServerStreamingCallable(
      ServerStreamingCallable<RequestT, ResponseT> inner, Set<Code> retryableCodes) {
    this.inner = inner;
    this.exceptionFactory = new GrpcApiExceptionFactory(retryableCodes);
  }

  @Override
  public void call(
      RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {

    inner.call(request, new ExceptionResponseObserver(responseObserver), context);
  }

  private class ExceptionResponseObserver implements ResponseObserver<ResponseT> {
    private ResponseObserver<ResponseT> innerObserver;
    private volatile CancellationException cancellationException;

    public ExceptionResponseObserver(ResponseObserver<ResponseT> innerObserver) {
      this.innerObserver = innerObserver;
    }

    @Override
    public void onStart(final StreamController controller) {
      innerObserver.onStart(
          new StreamController() {
            @Override
            public void cancel() {
              cancellationException = new CancellationException("User cancelled stream");
              controller.cancel();
            }

            @Override
            public void disableAutoInboundFlowControl() {
              controller.disableAutoInboundFlowControl();
            }

            @Override
            public void request(int count) {
              controller.request(count);
            }
          });
    }

    @Override
    public void onResponse(ResponseT response) {
      innerObserver.onResponse(response);
    }

    @Override
    public void onError(Throwable t) {
      if (cancellationException != null) {
        t = cancellationException;
      } else {
        t = exceptionFactory.create(t);
      }
      innerObserver.onError(t);
    }

    @Override
    public void onComplete() {
      innerObserver.onComplete();
    }
  }
}
