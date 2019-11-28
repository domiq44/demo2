
# Speed up Spring Boot startup time

## Step 2

*Spring Boot project.*

Replace

    @SpringBootApplication

in main application class by

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
