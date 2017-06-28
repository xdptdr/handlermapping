package com.github.xdptdr.notes.resteasy;

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

import com.github.xdptdr.notes.N;

public class Notes {

	public static void notes(N n) {
		// http://www.nounou-paris.fr/idees_prenoms.php?page=1&sexe=2&index_prenom=1&derniere_lettre=1&nombre_lettre=5

		n.s("8. Linking resources");

		n.todo(AddLinks.class, ELProvider.class, LinkELProvider.class, LinkResource.class, LinkResources.class,
				ParamBinding.class, ParentResource.class, ResourceFacade.class, ResourceID.class, ResourceIDs.class,
				RESTServiceDiscovery.class);

		n.todo(LogMessages.class, Messages.class);

		n.todo(BaseELResolver.class, BeanUtils.class, EL.class, LinkDecorator.class, NotFoundException.class,
				RESTUtils.class, ServiceDiscoveryException.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
