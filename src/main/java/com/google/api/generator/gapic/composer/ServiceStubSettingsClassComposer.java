// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.composer;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

public class ServiceStubSettingsClassComposer implements ClassComposer {
  private static final String CLASS_NAME_PATTERN = "%sStubSettings";
  private static final String SLASH = "/";
  private static final String LEFT_BRACE = "{";
  private static final String RIGHT_BRACE = "}";

  private static final ServiceStubSettingsClassComposer INSTANCE =
      new ServiceStubSettingsClassComposer();

  private static final Map<String, TypeNode> STATIC_TYPES = createStaticTypes();
  private static final VariableExpr DEFAULT_SERVICE_SCOPES_VAR_EXPR =
      createDefaultServiceScopesVarExpr();

  private ServiceStubSettingsClassComposer() {}

  public static ServiceStubSettingsClassComposer instance() {
    return INSTANCE;
  }

  @Override
  public GapicClass generate(Service service, Map<String, Message> ignore) {
    String pakkage = String.format("%s.stub", service.pakkage());
    Map<String, TypeNode> types = createDynamicTypes(service, pakkage);
    Map<String, VariableExpr> classMemberVarExprs = createClassMemberVarExprs(service, types);
    String className = getThisClassName(service.name());

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setAnnotations(createClassAnnotations())
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setExtendsType(createExtendsType(service, types))
            .setStatements(createClassStatements(service, types))
            .setMethods(createClassMethods(service, types))
            .setNestedClasses(Arrays.asList(createNestedBuilderClass(service, types)))
            .build();
    return GapicClass.create(GapicClass.Kind.STUB, classDef);
  }

  private static List<AnnotationNode> createClassAnnotations() {
    return Arrays.asList(
        AnnotationNode.withType(STATIC_TYPES.get("BetaApi")),
        AnnotationNode.builder()
            .setType(STATIC_TYPES.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
  }

  private static TypeNode createExtendsType(Service service, Map<String, TypeNode> types) {
    TypeNode thisClassType = types.get(getThisClassName(service.name()));
    return TypeNode.withReference(
        STATIC_TYPES
            .get("StubSettings")
            .reference()
            .copyAndSetGenerics(Arrays.asList(thisClassType.reference())));
  }

  private static Map<String, VariableExpr> createClassMemberVarExprs(
      Service service, Map<String, TypeNode> types) {
    // TODO(miraleung): Fill this out.
    return new HashMap<String, VariableExpr>();
  }

  private static List<Statement> createClassStatements(
      Service service, Map<String, TypeNode> types) {
    List<Expr> memberVars = new ArrayList<>();

    // Assign DEFAULT_SERVICE_SCOPES.
    VariableExpr defaultServiceScopesDeclVarExpr =
        DEFAULT_SERVICE_SCOPES_VAR_EXPR.toBuilder()
            .setIsDecl(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setIsFinal(true)
            .build();
    MethodInvocationExpr listBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(STATIC_TYPES.get("ImmutableList"))
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .setMethodName("builder")
            .build();
    for (String serviceScope : service.oauthScopes()) {

      listBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(listBuilderExpr)
              .setMethodName("add")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(serviceScope)))
              .build();
    }
    listBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(listBuilderExpr)
            .setMethodName("build")
            .setReturnType(DEFAULT_SERVICE_SCOPES_VAR_EXPR.type())
            .build();

    memberVars.add(
        AssignmentExpr.builder()
            .setVariableExpr(defaultServiceScopesDeclVarExpr)
            .setValueExpr(listBuilderExpr)
            .build());

    // TODO(miraleung): Fill this out.
    return memberVars.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList());
  }

  private static List<MethodDefinition> createClassMethods(
      Service service, Map<String, TypeNode> types) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    // TODO(miraleung): Fill this out.
    return javaMethods;
  }

  private static ClassDefinition createNestedBuilderClass(
      Service service, Map<String, TypeNode> types) {
    String thisClassName = getThisClassName(service.name());
    TypeNode outerThisClassType = types.get(thisClassName);

    String className = "Builder";

    // TODO(miraleung): Fill this out.
    return ClassDefinition.builder()
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setName(className)
        .build();
  }

  private static Map<String, TypeNode> createStaticTypes() {
    List<Class> concreteClazzes =
        Arrays.asList(
            ApiCallContext.class,
            ApiClientHeaderProvider.class,
            ApiFunction.class,
            ApiFuture.class,
            BatchedRequestIssuer.class,
            BatchingCallSettings.class,
            BatchingDescriptor.class,
            BatchingSettings.class,
            BetaApi.class,
            ClientContext.class,
            Duration.class,
            Empty.class,
            FlowControlSettings.class,
            GaxGrpcProperties.class,
            GaxProperties.class,
            Generated.class,
            GoogleCredentialsProvider.class,
            GrpcTransportChannel.class,
            IOException.class,
            ImmutableList.class,
            ImmutableMap.class,
            ImmutableSet.class,
            InstantiatingExecutorProvider.class,
            InstantiatingGrpcChannelProvider.class,
            LimitExceededBehavior.class,
            List.class,
            Lists.class,
            MonitoredResourceDescriptor.class,
            Operation.class,
            OperationCallSettings.class,
            OperationSnapshot.class,
            OperationTimedPollAlgorithm.class,
            PageContext.class,
            PagedCallSettings.class,
            PagedListDescriptor.class,
            PagedListResponseFactory.class,
            PartitionKey.class,
            ProtoOperationTransformers.class,
            RequestBuilder.class,
            RetrySettings.class,
            StatusCode.class,
            StubSettings.class,
            TransportChannelProvider.class,
            UnaryCallSettings.class,
            UnaryCallable.class);
    return concreteClazzes.stream()
        .collect(
            Collectors.toMap(
                c -> c.getSimpleName(),
                c -> TypeNode.withReference(ConcreteReference.withClazz(c))));
  }

  private static Map<String, TypeNode> createDynamicTypes(Service service, String pakkage) {
    String thisClassName = getThisClassName(service.name());
    Map<String, TypeNode> dynamicTypes = new HashMap<>();
    dynamicTypes.put(
        thisClassName,
        TypeNode.withReference(
            VaporReference.builder().setName(thisClassName).setPakkage(pakkage).build()));
    dynamicTypes.put(
        "Builder",
        TypeNode.withReference(
            VaporReference.builder()
                .setName("Builder")
                .setPakkage(pakkage)
                .setEnclosingClassName(thisClassName)
                .setIsStaticImport(true)
                .build()));

    // TODO(miraleung): Fill this out.
    return dynamicTypes;
  }

  private static VariableExpr createDefaultServiceScopesVarExpr() {
    TypeNode listStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableList.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                .build());
    return VariableExpr.withVariable(
        Variable.builder().setName("DEFAULT_SERVICE_SCOPES").setType(listStringType).build());
  }

  private static String getThisClassName(String serviceName) {
    return String.format(CLASS_NAME_PATTERN, JavaStyle.toUpperCamelCase(serviceName));
  }
}