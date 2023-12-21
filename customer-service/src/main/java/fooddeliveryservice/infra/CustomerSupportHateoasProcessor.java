package fooddeliveryservice.infra;

import fooddeliveryservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerSupportHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CustomerSupport>> {

    @Override
    public EntityModel<CustomerSupport> process(
        EntityModel<CustomerSupport> model
    ) {
        return model;
    }
}
