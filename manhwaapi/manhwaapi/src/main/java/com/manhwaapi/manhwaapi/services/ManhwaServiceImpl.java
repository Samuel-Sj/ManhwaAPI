package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.model.Manhwa;
import com.manhwaapi.manhwaapi.repository.ManhwaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ManhwaServiceImpl implements ManhwaService {
    @Autowired
    ManhwaRepository manhwaRepository;

    @Override
    public Manhwa saveManhwa(Manhwa manhwa) {
        return manhwaRepository.save(manhwa);
    }

    @Override
    public Manhwa fetchManhwa() {
        return null;
    }

    @Override
    public Manhwa updateManhwa(Manhwa manhwa, long id) {
        return null;
    }

    @Override
    public void deleteManhwaById(long id) {

    }

    @Override
    public void deleteManhwaByName(String name) {

    }
}
