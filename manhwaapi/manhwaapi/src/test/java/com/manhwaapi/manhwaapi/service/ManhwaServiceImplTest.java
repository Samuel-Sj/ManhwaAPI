package com.manhwaapi.manhwaapi.service;

import com.manhwaapi.manhwaapi.model.Manhwa;
import com.manhwaapi.manhwaapi.repository.ManhwaRepository;
import com.manhwaapi.manhwaapi.services.ManhwaServiceImpl;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ManhwaServiceImplTest {
    @Mock
    private ManhwaRepository manhwaRepository;
    @InjectMocks
    private ManhwaServiceImpl manhwaService;

    @Test
    void shouldSaveManhwa(){
        Manhwa manhwa = new Manhwa();
        manhwa.setName("Solo Leveling");
        when(manhwaRepository.save((manhwa)));
        Manhwa result = manhwaRepository.save(manhwa);

        assertEquals("solo leveling", result.getName());
        verify(manhwaRepository.existsByName("solo leveling"));
        verify(manhwaRepository.save(manhwa));
    }
    @Test
    void shouldNotSaveDuplicateManhwa() {
        Manhwa manhwa = new Manhwa();
        manhwa.setName("Solo Leveling");

        when(manhwaRepository.existsByName("solo leveling"))
                .thenReturn(true);

        assertThrows(
                IllegalArgumentException.class,
                () -> manhwaService.saveManhwa(manhwa)
        );

        verify(manhwaRepository, never()).save(any());
    }

    @Test
    void shouldFetchManhwaByName(){
        Manhwa manhwa = new Manhwa();
        manhwa.setName("SOLO LEVELING");

        when(manhwaRepository.findByName("solo leveling")).thenReturn(manhwa);

        Manhwa result = manhwaService.fetchManhwaByName("SOLO LEVELING");
        assertEquals("solo leveling", result.getName());

        verify(manhwaRepository.findByName("solo leveling"));
    }

}
