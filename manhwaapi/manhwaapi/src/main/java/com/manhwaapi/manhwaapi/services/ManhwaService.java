package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.model.Manhwa;


public interface ManhwaService {
    Manhwa saveManhwa(Manhwa manhwa);
    Manhwa fetchManhwaByName(String Name);
    Manhwa fetchManhwaByReleasedYear(int releasedYear);
    Manhwa fetchManhwByFinished (Boolean isFininshed);
    Manhwa updateManhwa(Manhwa manhwa, Long id);
    void deleteManhwaById (Long id);
    void deleteManhwaByName(String name);

}
