package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.CategoryTestSamples.*;
import static com.mycompany.myapp.domain.VideoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Category.class);
        Category category1 = getCategorySample1();
        Category category2 = new Category();
        assertThat(category1).isNotEqualTo(category2);

        category2.setId(category1.getId());
        assertThat(category1).isEqualTo(category2);

        category2 = getCategorySample2();
        assertThat(category1).isNotEqualTo(category2);
    }

    @Test
    void videosTest() throws Exception {
        Category category = getCategoryRandomSampleGenerator();
        Video videoBack = getVideoRandomSampleGenerator();

        category.addVideos(videoBack);
        assertThat(category.getVideos()).containsOnly(videoBack);

        category.removeVideos(videoBack);
        assertThat(category.getVideos()).doesNotContain(videoBack);

        category.videos(new HashSet<>(Set.of(videoBack)));
        assertThat(category.getVideos()).containsOnly(videoBack);

        category.setVideos(new HashSet<>());
        assertThat(category.getVideos()).doesNotContain(videoBack);
    }
}
