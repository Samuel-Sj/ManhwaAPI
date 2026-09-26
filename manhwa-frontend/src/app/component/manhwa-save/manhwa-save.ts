import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Manhwa from '../../../models/manhwa';
import { ManhwaService } from '../../../services/manhwa.service';

@Component({
  selector: 'app-manhwa-save',
  imports: [FormsModule],
  templateUrl: './manhwa-save.html',
  styleUrl: './manhwa-save.css',
})
export class ManhwaForm {
  manhwa: Manhwa = {
    name: '',
    releaseYear: new Date().getFullYear(),
    isFinished: false,
  }

  success = signal(false);
  error = signal<string | null>(null);

  constructor (private manhwaService: ManhwaService) {};

  submit(){
    this.success.set(false);
    this.error.set(null);

    this.manhwaService.saveManhwa(this.manhwa).subscribe({
      next: ()=>{
        this.success.set(true);
        this.manhwa = {name: '', releaseYear: new Date().getFullYear(),isFinished: false};
      },
      error: () =>{
        this.error.set('Erro ao salvar o manhwa. Verifique a API')
      }
    })
  }


}