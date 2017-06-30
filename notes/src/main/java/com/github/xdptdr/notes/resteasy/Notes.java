package com.github.xdptdr.notes.resteasy;

import javax.xml.stream.util.EventReaderDelegate;

import org.jboss.resteasy.annotations.security.doseta.After;
import org.jboss.resteasy.annotations.security.doseta.Signed;
import org.jboss.resteasy.annotations.security.doseta.Verifications;
import org.jboss.resteasy.annotations.security.doseta.Verify;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.ELProvider;
import org.jboss.resteasy.links.LinkELProvider;
import org.jboss.resteasy.links.LinkResource;
import org.jboss.resteasy.links.LinkResources;
import org.jboss.resteasy.links.ParamBinding;
import org.jboss.resteasy.links.ParentResource;
import org.jboss.resteasy.links.RESTServiceDiscovery;
import org.jboss.resteasy.links.ResourceFacade;
import org.jboss.resteasy.links.ResourceID;
import org.jboss.resteasy.links.ResourceIDs;
import org.jboss.resteasy.links.i18n.LogMessages;
import org.jboss.resteasy.links.i18n.Messages;
import org.jboss.resteasy.links.impl.BaseELResolver;
import org.jboss.resteasy.links.impl.BeanUtils;
import org.jboss.resteasy.links.impl.EL;
import org.jboss.resteasy.links.impl.LinkDecorator;
import org.jboss.resteasy.links.impl.NotFoundException;
import org.jboss.resteasy.links.impl.RESTUtils;
import org.jboss.resteasy.links.impl.ServiceDiscoveryException;
import org.jboss.resteasy.security.BouncyIntegration;
import org.jboss.resteasy.security.DerUtils;
import org.jboss.resteasy.security.KeyTools;
import org.jboss.resteasy.security.PemUtils;
import org.jboss.resteasy.security.SigningAlgorithm;
import org.jboss.resteasy.security.doseta.AbstractDigitalSigningHeaderDecorator;
import org.jboss.resteasy.security.doseta.AbstractDigitalVerificationHeaderDecorator;
import org.jboss.resteasy.security.doseta.ClientDigitalSigningHeaderDecoratorFeature;
import org.jboss.resteasy.security.doseta.ClientDigitalVerificationHeaderDecoratorFeature;
import org.jboss.resteasy.security.doseta.ConfiguredDosetaKeyRepository;
import org.jboss.resteasy.security.doseta.DKIMSignature;
import org.jboss.resteasy.security.doseta.DigitalSigningHeaderDecoratorClientExecutionInterceptor;
import org.jboss.resteasy.security.doseta.DigitalSigningInterceptor;
import org.jboss.resteasy.security.doseta.DigitalVerificationHeaderDecoratorClientExecutionInterceptor;
import org.jboss.resteasy.security.doseta.DigitalVerificationInterceptor;
import org.jboss.resteasy.security.doseta.DosetaKeyRepository;
import org.jboss.resteasy.security.doseta.KeyRepository;
import org.jboss.resteasy.security.doseta.KeyStoreKeyRepository;
import org.jboss.resteasy.security.doseta.ServerDigitalSigningHeaderDecoratorFeature;
import org.jboss.resteasy.security.doseta.ServerDigitalVerificationHeaderDecoratorFeature;
import org.jboss.resteasy.security.doseta.UnauthorizedSignatureException;
import org.jboss.resteasy.security.doseta.Verification;
import org.jboss.resteasy.security.doseta.VerificationResult;
import org.jboss.resteasy.security.doseta.VerificationResultSet;
import org.jboss.resteasy.security.doseta.VerificationResults;
import org.jboss.resteasy.security.doseta.Verifier;
import org.jboss.resteasy.security.smime.EnvelopedInput;
import org.jboss.resteasy.security.smime.EnvelopedInputImpl;
import org.jboss.resteasy.security.smime.EnvelopedOutput;
import org.jboss.resteasy.security.smime.EnvelopedReader;
import org.jboss.resteasy.security.smime.EnvelopedWriter;
import org.jboss.resteasy.security.smime.MultipartSignedInputImpl;
import org.jboss.resteasy.security.smime.MultipartSignedReader;
import org.jboss.resteasy.security.smime.MultipartSignedWriter;
import org.jboss.resteasy.security.smime.PKCS7SignatureInput;
import org.jboss.resteasy.security.smime.PKCS7SignatureReader;
import org.jboss.resteasy.security.smime.PKCS7SignatureTextWriter;
import org.jboss.resteasy.security.smime.PKCS7SignatureWriter;
import org.jboss.resteasy.security.smime.SMIMEOutput;
import org.jboss.resteasy.security.smime.SignedInput;

import com.github.xdptdr.mbjaxrs.c.agate.AgateEndpoint;
import com.github.xdptdr.mbwar.jaxrs.clients.agate.AgateCLI;
import com.github.xdptdr.notes.N;

public class Notes {

	public static void notes(N n) {
		// http://www.nounou-paris.fr/idees_prenoms.php?page=1&sexe=2&index_prenom=1&derniere_lettre=1&nombre_lettre=5

		n.k(AgateEndpoint.class, AgateCLI.class).s(" illustrates how to use ").k(AddLinks.class, LinkResource.class,
				RESTServiceDiscovery.class);

		todoLinks(n);
		todoCrypto(n);

	}

	private static void todoLinks(N n) {

		n.todo(AddLinks.class, ELProvider.class, LinkELProvider.class, LinkResource.class, LinkResources.class,
				ParamBinding.class, ParentResource.class, ResourceFacade.class, ResourceID.class, ResourceIDs.class,
				RESTServiceDiscovery.class);

		n.todo(LogMessages.class, Messages.class);

		n.todo(BaseELResolver.class, BeanUtils.class, EL.class, LinkDecorator.class, NotFoundException.class,
				RESTUtils.class, ServiceDiscoveryException.class);

	}

	private static void todoCrypto(N n) {

		n.todo(After.class, Signed.class, Verifications.class, Verify.class);

		n.todo(BouncyIntegration.class, DerUtils.class, KeyTools.class, PemUtils.class, SigningAlgorithm.class);

		n.todo(AbstractDigitalSigningHeaderDecorator.class, AbstractDigitalVerificationHeaderDecorator.class,
				ClientDigitalSigningHeaderDecoratorFeature.class, ClientDigitalVerificationHeaderDecoratorFeature.class,
				ConfiguredDosetaKeyRepository.class, DigitalSigningHeaderDecoratorClientExecutionInterceptor.class,
				DigitalSigningInterceptor.class, DigitalVerificationHeaderDecoratorClientExecutionInterceptor.class,
				DigitalVerificationInterceptor.class, DKIMSignature.class, DosetaKeyRepository.class,
				KeyRepository.class, KeyStoreKeyRepository.class, ServerDigitalSigningHeaderDecoratorFeature.class,
				ServerDigitalVerificationHeaderDecoratorFeature.class, UnauthorizedSignatureException.class,
				Verification.class, VerificationResult.class, VerificationResults.class, VerificationResultSet.class,
				Verifier.class);

		n.todo(org.jboss.resteasy.security.doseta.i18n.LogMessages.class,
				org.jboss.resteasy.security.doseta.i18n.Messages.class);

		n.todo(EnvelopedInput.class, EnvelopedInputImpl.class, EnvelopedOutput.class, EnvelopedReader.class,
				EnvelopedWriter.class, MultipartSignedInputImpl.class, MultipartSignedReader.class,
				MultipartSignedWriter.class, PKCS7SignatureInput.class, PKCS7SignatureReader.class,
				PKCS7SignatureTextWriter.class, PKCS7SignatureWriter.class, SignedInput.class, SMIMEOutput.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
