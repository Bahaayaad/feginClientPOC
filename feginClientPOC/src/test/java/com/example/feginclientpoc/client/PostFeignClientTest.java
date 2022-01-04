package com.example.feginclientpoc.client;

import com.example.feginclientpoc.domain.Post;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import org.springframework.test.context.ActiveProfiles;

import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostFeignClientTest {


    @Qualifier("com.example.feginclientpoc.client.PostFeignClient")
    @Autowired
    PostFeignClient postFeignClient;

    @Test
    public void getAllPosts_whenValidClient_returnValidResponse() throws Exception {
        // Using WireMock to mock client API:
        stubFor(WireMock.get(WireMock.urlEqualTo("/posts"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(read("stubs/posts.json"))));

        List<Post> posts = postFeignClient.getAllPosts();
        Post post = posts.get(0);

        // We're asserting if WireMock responded properly
        assertThat(posts).hasSize(10);
        assertThat(post.getId()).isEqualTo(1);
        assertThat(post.getUserId()).isEqualTo(1);
        assertThat(post.getTitle()).isEqualTo("title");
        assertThat(post.getBody()).isEqualTo("body");
    }

    private String read(String location) throws IOException {
        return IOUtils.toString(new ClassPathResource(location).getInputStream(), String.valueOf(StandardCharsets.UTF_8));
    }

}