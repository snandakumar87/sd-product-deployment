package com.redhat.offermanagement.routes;

import javax.annotation.Generated;

import com.redhat.bian.servicedomain.models.BianResponse;
import com.redhat.bian.servicedomain.models.CRCustomerEligibilityAssessmentEvaluateInputModel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Generated from Swagger specification by Camel REST DSL generator.
 */
@ComponentScan
@Component
@Generated("org.apache.camel.generator.swagger.PathGenerator")
public final class CamelRoutes extends RouteBuilder {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/service/*");
        registration.setName("CamelServlet");
        return registration;
    }

    public void configure() {

        restConfiguration()
                .component("servlet")

                .bindingMode(RestBindingMode.auto)
                .producerComponent("http4").host("localhost:8085/service")
                .apiContextPath("/swagger") //swagger endpoint path
                .apiContextRouteId("swagger") //id of route providing the swagger endpoint

                //Swagger properties

                .apiProperty("api.title", "Example REST api")
                .apiProperty("api.version", "1.0")
        ;

        rest()
                .post("/customer-product-service-eligibility/activation")
                .id("activateSDCustomerProductServiceEligibility")
                .description("Activate  a  SDCustomerProductServiceEligibility servicing session")
                .produces("application/json")
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("SDCustomerProductServiceEligibility Request Payload")
                .endParam()
                .to("direct:activateSDCustomerProductServiceEligibility")

                .put("/customer-product-service-eligibility/{sd-reference-id}/configuration")
                .id("configureSDCustomerProductServiceEligibility")
                .description("Update an active SDCustomerProductServiceEligibility session configuration")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("SDCustomerProductServiceEligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("SDCustomerProductServiceEligibility Configure Request Payload")
                .endParam()
                .to("direct:configureSDCustomerProductServiceEligibility")

                .put("/customer-product-service-eligibility/{sd-reference-id}/feedback")
                .id("feedbackSDCustomerProductServiceEligibility")
                .description("Capturing feedback against the SDCustomerProductServiceEligibility service that can target different levels of detail: SD/CR/BQ")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("SDCustomerProductServiceEligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("SDCustomerProductServiceEligibility Feedback Request Payload")
                .endParam()
                .to("direct:feedbackSDCustomerProductServiceEligibility")

                .get("/customer-product-service-eligibility/{sd-reference-id}")
                .id("retrieveSDCustomerProductServiceEligibility")
                .description("Analytical views maintained by the SDCustomerProductServiceEligibility service center for management reporting and analysis purposes")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("SDCustomerProductServiceEligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/SDCustomerProductServiceEligibilityRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveSDCustomerProductServiceEligibility")

                .post("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/evaluation")
                .id("evaluateCustomerEligibilityAssessment")
                .description("Evaluate a customer's eligibility for a product/service")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("CustomerEligibilityAssessment Request Payload")
                .endParam()


                .to("direct:evaluateCustomerEligibilityAssessment")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/update")
                .id("updateCustomerEligibilityAssessment")
                .description("Update an evaluation request")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Customer Eligibility Assessment Request Payload")
                .endParam()
                .to("direct:updateCustomerEligibilityAssessment")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/exchange")
                .id("exchangeCustomerEligibilityAssessmentUpdate")
                .description("Accept, reject, verify etc. an eligibility assessment")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Customer Eligibility Assessment Request Payload")
                .endParam()
                .to("direct:exchangeCustomerEligibilityAssessmentUpdate")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/execution")
                .id("executeCustomerEligibilityAssessmentUpdate")
                .description("Execute an automated action against an active evaluation (e.g. provide additional data)")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Customer Eligibility Assessment Request Payload")
                .endParam()
                .to("direct:executeCustomerEligibilityAssessmentUpdate")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/requisition")
                .id("requestCustomerEligibilityAssessmentUpdate")
                .description("Request manual intervention in an evaluation (e.g. engage a specialist or negotiator)")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Customer Eligibility Assessment Request Payload")
                .endParam()
                .to("direct:requestCustomerEligibilityAssessmentUpdate")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/grant")
                .id("grantCustomerEligibilityAssessmentUpdate")
                .description("Obtain a permission grant reflecting eligibility (perhaps defining a term or other considerations)")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Customer Eligibility Assessment Request Payload")
                .endParam()
                .to("direct:grantCustomerEligibilityAssessmentUpdate")

                .get("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}")
                .id("retrieveCustomerProductServiceEligibility")
                .description("Retrieve details about an eligibility request")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/CRCustomerEligibilityAssessmentRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerProductServiceEligibility")

                .get("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/eligibilitycheck/{bq-reference-id}/")
                .id("retrieveCustomerEligibilityAssessmentEligibilityCheck")
                .description("Retrieve details about an eligibility assessment .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("EligibilityCheck Instance Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/BQEligibilityCheckRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerEligibilityAssessmentEligibilityCheck")

                .put("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/nextbest/{bq-reference-id}/update")
                .id("updateCustomerEligibilityAssessmentNextBest")
                .description("Update details about a next best eligibility test")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("NextBest Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("NextBest Request Payload")
                .endParam()
                .to("direct:updateCustomerEligibilityAssessmentNextBest")

                .get("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/nextbest/{bq-reference-id}/")
                .id("retrieveCustomerEligibilityAssessmentNextBest")
                .description("Retrieve details about a next best test .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("NextBest Instance Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/BQNextBestRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveCustomerEligibilityAssessmentNextBest")

                .get("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment")
                .id("RetrieveCustomerProductServiceEligibilityReferenceIds")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("collection-filter")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Filter to refine the result set. ex- CustomerProductServiceEligibility Instance Status='active'")
                .endParam()
                .to("direct:RetrieveCustomerProductServiceEligibilityReferenceIds")

                .get("/customer-product-service-eligibility/customer-eligibility-assessment/behavior-qualifiers/")
                .id("RetrieveCustomerProductServiceEligibilityBehaviorQualifiers")
                .produces("application/json")
                .to("direct:RetrieveCustomerProductServiceEligibilityBehaviorQualifiers")

                .get("/customer-product-service-eligibility/{sd-reference-id}/customer-eligibility-assessment/{cr-reference-id}/{behavior-qualifier}/")
                .id("RetrieveCustomerProductServiceEligibilityBehaviorQualifierReferenceIds")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Product Service Eligibility Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Customer Eligibility Assessment Instance Reference")
                .endParam()
                .param()
                .name("behavior-qualifier")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Behavior Qualifier Name. ex- NextBest")
                .endParam()
                .param()
                .name("collection-filter")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Filter to refine the result set. ex- NextBest Instance Status = 'pending'")
                .endParam()
                .to("direct:RetrieveCustomerProductServiceEligibilityBehaviorQualifierReferenceIds");
        from("direct:evaluateCustomerEligibilityAssessment")
                .bean(TransformerBean.class,"evaluateEligibility")

        ;

    }
}
