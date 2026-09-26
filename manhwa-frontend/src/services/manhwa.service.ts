import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Manhwa from '../models/manhwa';

@Injectable({
  providedIn: 'root',
})
export class ManhwaService {
  private apiUrl = 'http://localhost:8080/manhwa';

  constructor(private http: HttpClient) {}

  getByName(name: string) {
    return this.http.get<Manhwa>(
      `${this.apiUrl}/name/${encodeURIComponent(name)}`
    );
  }

  getByYear(year: number) {
    return this.http.get<Manhwa>(
      `${this.apiUrl}/year/${encodeURIComponent(year)}`
    );
  }

  getByFinished(isFinished: boolean) {

    return this.http.get<Manhwa>(
      `${this.apiUrl}/finished/${encodeURIComponent(isFinished)}`
    );
  }

  saveManhwa (manhwa: Manhwa){
    return this.http.post<Manhwa>(
      this.apiUrl,manhwa
    )
  };
}
 