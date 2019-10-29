package com.soap.tutorial;

import localhost.universities.GetUniversityRequest;
import localhost.universities.GetUniversityResponse;
import localhost.universities.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UniversityEndpoint {

    private static final String NAMESPACE_URI = "http://localhost/universities";

    private UniversitiesRepository universitiesRepository;

    @Autowired
    public UniversityEndpoint(UniversitiesRepository universitiesRepository) {
        this.universitiesRepository = universitiesRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universitiesRepository.getUniversityByName(request.getName()));
        return response;
    }
}
