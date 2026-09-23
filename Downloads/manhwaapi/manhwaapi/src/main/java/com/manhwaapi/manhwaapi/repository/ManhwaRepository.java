package com.manhwaapi.manhwaapi.repository;

import com.manhwaapi.manhwaapi.model.Manhwa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManhwaRepository extends JpaRepository<Manhwa,Long> {
    public Manhwa findByName(String name);
    public Manhwa findByReleaseYear(int releaseYear);
    public Manhwa findByFinished (boolean isFinished);

}
