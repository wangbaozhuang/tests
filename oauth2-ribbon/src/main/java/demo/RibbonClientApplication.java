package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableAutoConfiguration
@RibbonClient("foo")
@EnableOAuth2Client
public class RibbonClientApplication {

	@LoadBalanced
	@Bean
	public OAuth2RestTemplate loadBalancedOauth2RestTemplate(OAuth2ProtectedResourceDetails resource,
			OAuth2ClientContext context) {
		return new OAuth2RestTemplate(resource, context);
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
