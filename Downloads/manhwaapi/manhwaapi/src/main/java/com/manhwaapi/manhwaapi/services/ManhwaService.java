package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.model.Manhwa;


public interface ManhwaService {
    Manhwa saveManhwa(Manhwa manhwa);
    Manhwa fetchManhwa();
    Manhwa updateManhwa(Manhwa manhwa, long id);
    void deleteManhwaById (long id);
    void deleteManhwaByName(String name);



}
