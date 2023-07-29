package io.red.alice.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class FileSystemStorageServiceTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StorageService storageService;

    @Test
    void shouldSaveFile() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("photo", "test.jpg",
                "image/jpeg", "Spring Framework".getBytes());

        this.mvc.perform(multipart("/v1/item")
                .file(multipartFile)
        ).andExpect(status().isFound());

        then(storageService).should().store(multipartFile);


    }

}
