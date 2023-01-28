# OStock-MicroServices
An Asset Management product which provides coverage for inventory, licensing, compliance cost and resource managementCancel changes

# To Run
clean package
docker build
docker run --publish 8080:8080 optimagrowth/licensing-service



# Licensing Service
Just Started with the Licensing Service-
To Do-
Service, apis for crud

api examples
--post
http://localhost:8080/v1/organization/s/license/
--body
{
    "licenseId": "012345678",
    "organizationId":"product1",
    "description":"Software Product",
    "productName":"OStock",
    "licenseType":"full"

}
--get
http://localhost:8080/v1/organization/s/license/012345678


--Due to mac m1 and beyond chips-- fabric8io/docker-maven-plugin is used
