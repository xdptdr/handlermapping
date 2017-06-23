package com.github.xdptdr.notes.spring.security.core;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AfterInvocationProvider;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.PermissionCacheOptimizer;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.annotation.AnnotationMetadataExtractor;
import org.springframework.security.access.annotation.Jsr250MethodSecurityMetadataSource;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;
import org.springframework.security.access.annotation.Jsr250Voter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.access.expression.DenyAllPermissionEvaluator;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.ExpressionBasedAnnotationAttributeFactory;
import org.springframework.security.access.expression.method.ExpressionBasedPostInvocationAdvice;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;

import com.github.xdptdr.notes.N;

public class Notes {
	public static void notes(N n) {

		n.todo(AccessDecisionManager.class);
		n.todo(AccessDecisionVoter.class);
		n.todo(AccessDeniedException.class);
		n.todo(AfterInvocationProvider.class);
		n.todo(AuthorizationServiceException.class);
		n.todo(ConfigAttribute.class);
		n.todo(PermissionCacheOptimizer.class);
		n.todo(PermissionEvaluator.class);
		n.todo(SecurityConfig.class);
		n.todo(SecurityMetadataSource.class);

		n.todo(AnnotationMetadataExtractor.class);
		n.todo(Jsr250MethodSecurityMetadataSource.class);
		n.todo(Jsr250SecurityConfig.class);
		n.todo(Jsr250Voter.class);
		n.todo(Secured.class);
		n.todo(SecuredAnnotationSecurityMetadataSource.class);
//
		n.todo(AbstractAuthorizationEvent.class);
		n.todo(AuthenticationCredentialsNotFoundEvent.class);
		n.todo(AuthorizationFailureEvent.class);
		n.todo(AuthorizedEvent.class);
		n.todo(LoggerListener.class);
		n.todo(PublicInvocationEvent.class);
//
//		n.todo(AbstractSecurityExpressionHandler.class);
		n.todo(DenyAllPermissionEvaluator.class);
		n.todo(ExpressionUtils.class);
		n.todo(SecurityExpressionHandler.class);
		n.todo(SecurityExpressionOperations.class);
		n.todo(SecurityExpressionRoot.class);
//
		n.todo(DefaultMethodSecurityExpressionHandler.class);
		n.todo(ExpressionBasedAnnotationAttributeFactory.class);
		n.todo(ExpressionBasedPostInvocationAdvice.class);
		n.todo(ExpressionBasedPreInvocationAdvice.class);
		n.todo(MethodSecurityExpressionHandler.class);
		n.todo(MethodSecurityExpressionOperations.class);
//
//		n.todo(CycleInRoleHierarchyException.class);
//		n.todo(NullRoleHierarchy.class);
//		n.todo(RoleHierarchy.class);
//		n.todo(RoleHierarchyAuthoritiesMapper.class);
//		n.todo(RoleHierarchyImpl.class);
//		n.todo(RoleHierarchyUtils.class);
//
//		n.todo(AbstractSecurityInterceptor.class);
//		n.todo(AfterInvocationManager.class);
//		n.todo(AfterInvocationProviderManager.class);
//		n.todo(InterceptorStatusToken.class);
//		n.todo(MethodInvocationPrivilegeEvaluator.class);
//		n.todo(RunAsImplAuthenticationProvider.class);
//		n.todo(RunAsManager.class);
//		n.todo(RunAsManagerImpl.class);
//		n.todo(RunAsUserToken.class);
//
//		n.todo(MethodSecurityInterceptor.class);
//		n.todo(MethodSecurityMetadataSourceAdvisor.class);
//
//		n.todo(AspectJCallback.class);
//		n.todo(AspectJMethodSecurityInterceptor.class);
//		n.todo(MethodInvocationAdapter.class);
//
//		n.todo(AbstractFallbackMethodSecurityMetadataSource.class);
//		n.todo(AbstractMethodSecurityMetadataSource.class);
//		n.todo(DelegatingMethodSecurityMetadataSource.class);
//		n.todo(MapBasedMethodSecurityMetadataSource.class);
//		n.todo(MethodSecurityMetadataSource.class);
//		n.todo(P.class);
//
//		n.todo(PostAuthorize.class);
//		n.todo(PostFilter.class);
//		n.todo(PostInvocationAdviceProvider.class);
//		n.todo(PostInvocationAttribute.class);
//		n.todo(PostInvocationAuthorizationAdvice.class);
//		n.todo(PreAuthorize.class);
//		n.todo(PreFilter.class);
//		n.todo(PreInvocationAttribute.class);
//		n.todo(PreInvocationAuthorizationAdvice.class);
//		n.todo(PreInvocationAuthorizationAdviceVoter.class);
//		n.todo(PrePostAnnotationSecurityMetadataSource.class);
//		n.todo(PrePostInvocationAttributeFactory.class);
//
//		n.todo(AbstractAccessDecisionManager.class);
//		n.todo(AbstractAclVoter.class);
//		n.todo(AffirmativeBased.class);
//		n.todo(AuthenticatedVoter.class);
//		n.todo(ConsensusBased.class);
//		n.todo(RoleHierarchyVoter.class);
//		n.todo(RoleVoter.class);
//		n.todo(UnanimousBased.class);
//
//		n.todo(AbstractAuthenticationToken.class);
//		n.todo(AccountExpiredException.class);
//		n.todo(AccountStatusException.class);
//		n.todo(AccountStatusUserDetailsChecker.class);
//		n.todo(AnonymousAuthenticationProvider.class);
//		n.todo(AnonymousAuthenticationToken.class);
//		n.todo(AuthenticationCredentialsNotFoundException.class);
//		n.todo(AuthenticationDetailsSource.class);
//		n.todo(AuthenticationEventPublisher.class);
//		n.todo(AuthenticationManager.class);
//		n.todo(AuthenticationProvider.class);
//		n.todo(AuthenticationServiceException.class);
//		n.todo(AuthenticationTrustResolver.class);
//		n.todo(AuthenticationTrustResolverImpl.class);
//		n.todo(BadCredentialsException.class);
//		n.todo(CredentialsExpiredException.class);
//		n.todo(DefaultAuthenticationEventPublisher.class);
//		n.todo(DisabledException.class);
//		n.todo(InsufficientAuthenticationException.class);
//		n.todo(InternalAuthenticationServiceException.class);
//		n.todo(LockedException.class);
//		n.todo(ProviderManager.class);
//		n.todo(ProviderNotFoundException.class);
//		n.todo(RememberMeAuthenticationProvider.class);
//		n.todo(RememberMeAuthenticationToken.class);
//		n.todo(TestingAuthenticationProvider.class);
//		n.todo(TestingAuthenticationToken.class);
//		n.todo(UsernamePasswordAuthenticationToken.class);
//
//		n.todo(AbstractUserDetailsAuthenticationProvider.class);
//		n.todo(DaoAuthenticationProvider.class);
//		n.todo(ReflectionSaltSource.class);
//		n.todo(SaltSource.class);
//		n.todo(SystemWideSaltSource.class);
//
//		n.todo(BaseDigestPasswordEncoder.class);
//		n.todo(BasePasswordEncoder.class);
//		n.todo(LdapShaPasswordEncoder.class);
//		n.todo(Md4PasswordEncoder.class);
//		n.todo(Md5PasswordEncoder.class);
//		n.todo(MessageDigestPasswordEncoder.class);
//		n.todo(PasswordEncoder.class);
//		n.todo(PlaintextPasswordEncoder.class);
//		n.todo(ShaPasswordEncoder.class);
//
//		n.todo(AbstractAuthenticationEvent.class);
//		n.todo(AbstractAuthenticationFailureEvent.class);
//		n.todo(AuthenticationFailureBadCredentialsEvent.class);
//		n.todo(AuthenticationFailureCredentialsExpiredEvent.class);
//		n.todo(AuthenticationFailureDisabledEvent.class);
//		n.todo(AuthenticationFailureExpiredEvent.class);
//		n.todo(AuthenticationFailureLockedEvent.class);
//		n.todo(AuthenticationFailureProviderNotFoundEvent.class);
//		n.todo(AuthenticationFailureProxyUntrustedEvent.class);
//		n.todo(AuthenticationFailureServiceExceptionEvent.class);
//		n.todo(AuthenticationSuccessEvent.class);
//		n.todo(InteractiveAuthenticationSuccessEvent.class);
//		n.todo(LoggerListener.class);
//
//		n.todo(AbstractJaasAuthenticationProvider.class);
//		n.todo(AuthorityGranter.class);
//		n.todo(DefaultJaasAuthenticationProvider.class);
//		n.todo(DefaultLoginExceptionResolver.class);
//		n.todo(JaasAuthenticationCallbackHandler.class);
//		n.todo(JaasAuthenticationProvider.class);
//		n.todo(JaasAuthenticationToken.class);
//		n.todo(JaasGrantedAuthority.class);
//		n.todo(JaasNameCallbackHandler.class);
//		n.todo(JaasPasswordCallbackHandler.class);
//		n.todo(LoginExceptionResolver.class);
//		n.todo(SecurityContextLoginModule.class);
//
//		n.todo(JaasAuthenticationEvent.class);
//		n.todo(JaasAuthenticationFailedEvent.class);
//		n.todo(JaasAuthenticationSuccessEvent.class);
//
//		n.todo(InMemoryConfiguration.class);
//
//		n.todo(RemoteAuthenticationException.class);
//		n.todo(RemoteAuthenticationManager.class);
//		n.todo(RemoteAuthenticationManagerImpl.class);
//		n.todo(RemoteAuthenticationProvider.class);
//
//		n.todo(DelegatingSecurityContextCallable.class);
//		n.todo(DelegatingSecurityContextExecutor.class);
//		n.todo(DelegatingSecurityContextExecutorService.class);
//		n.todo(DelegatingSecurityContextRunnable.class);
//		n.todo(DelegatingSecurityContextScheduledExecutorService.class);
//
//		n.todo(DelegatingApplicationListener.class);
//
//		n.todo(Authentication.class);
//		n.todo(AuthenticationException.class);
//		n.todo(CredentialsContainer.class);
//		n.todo(GrantedAuthority.class);
//		n.todo(SpringSecurityCoreVersion.class);
//		n.todo(SpringSecurityMessageSource.class);
//
//		n.todo(AuthenticationPrincipal.class);
//
//		n.todo(AuthorityUtils.class);
//		n.todo(GrantedAuthoritiesContainer.class);
//		n.todo(SimpleGrantedAuthority.class);
//
//		n.todo(Attributes2GrantedAuthoritiesMapper.class);
//		n.todo(GrantedAuthoritiesMapper.class);
//		n.todo(MapBasedAttributes2GrantedAuthoritiesMapper.class);
//		n.todo(MappableAttributesRetriever.class);
//		n.todo(NullAuthoritiesMapper.class);
//		n.todo(SimpleAttributes2GrantedAuthoritiesMapper.class);
//		n.todo(SimpleAuthorityMapper.class);
//		n.todo(SimpleMappableAttributesRetriever.class);
//
//		n.todo(SecurityContext.class);
//		n.todo(SecurityContextHolder.class);
//		n.todo(SecurityContextHolderStrategy.class);
//		n.todo(SecurityContextImpl.class);
//
//		n.todo(AnnotationParameterNameDiscoverer.class);
//		n.todo(DefaultSecurityParameterNameDiscoverer.class);
//
//		n.todo(SessionCreationEvent.class);
//		n.todo(SessionDestroyedEvent.class);
//		n.todo(SessionInformation.class);
//		n.todo(SessionRegistry.class);
//		n.todo(SessionRegistryImpl.class);
//
//		n.todo(DefaultToken.class);
//		n.todo(KeyBasedPersistenceTokenService.class);
//		n.todo(SecureRandomFactoryBean.class);
//		n.todo(Sha512DigestUtils.class);
//		n.todo(Token.class);
//		n.todo(TokenService.class);
//
//		n.todo(AuthenticationUserDetailsService.class);
//		n.todo(User.class);
//		n.todo(UserCache.class);
//		n.todo(UserDetails.class);
//		n.todo(UserDetailsByNameServiceWrapper.class);
//		n.todo(UserDetailsChecker.class);
//		n.todo(UserDetailsService.class);
//		n.todo(UsernameNotFoundException.class);
//
//		n.todo(EhCacheBasedUserCache.class);
//		n.todo(NullUserCache.class);
//		n.todo(SpringCacheBasedUserCache.class);
//
//		n.todo(JdbcDaoImpl.class);
//
//		n.todo(UserAttribute.class);
//		n.todo(UserAttributeEditor.class);
//
//		n.todo(BCrypt.class);
//		n.todo(BCryptPasswordEncoder.class);
//
//		n.todo(Base64.class);
//		n.todo(Hex.class);
//		n.todo(Utf8.class);
//
//		n.todo(BouncyCastleAesCbcBytesEncryptor.class);
//		n.todo(BouncyCastleAesGcmBytesEncryptor.class);
//		n.todo(BytesEncryptor.class);
//		n.todo(Encryptors.class);
//		n.todo(TextEncryptor.class);
//
//		n.todo(BytesKeyGenerator.class);
//		n.todo(KeyGenerators.class);
//		n.todo(StringKeyGenerator.class);
//
//		n.todo(AbstractPasswordEncoder.class);
//		n.todo(NoOpPasswordEncoder.class);
//		n.todo(PasswordEncoder.class);
//		n.todo(Pbkdf2PasswordEncoder.class);
//		n.todo(StandardPasswordEncoder.class);
//
//		n.todo(SCryptPasswordEncoder.class);
//
//		n.todo(EncodingUtils.class);
//
//		n.todo(CoreJackson2Module.class);
//		n.todo(SecurityJackson2Modules.class);
//		n.todo(SimpleGrantedAuthorityMixin.class);
//
//		n.todo(GroupManager.class);
//		n.todo(InMemoryUserDetailsManager.class);
//		n.todo(JdbcUserDetailsManager.class);
//		n.todo(UserDetailsManager.class);
//
//		n.todo(DelegatingSecurityContextSchedulingTaskExecutor.class);
//
//		n.todo(DelegatingSecurityContextAsyncTaskExecutor.class);
//		n.todo(DelegatingSecurityContextTaskExecutor.class);
//
//		n.todo(FieldUtils.class);
//		n.todo(InMemoryResource.class);
//		n.todo(MethodInvocationUtils.class);
//		n.todo(SimpleMethodInvocation.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
