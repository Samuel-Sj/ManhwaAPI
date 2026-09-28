import { Routes } from '@angular/router';
import { ManhwaSearch } from './component/manhwa-search/manhwa-search';
import { ManhwaForm } from './component/manhwa-save/manhwa-save';
import {ManhwaResult} from './component/manhwa-result/manhwa-result'

export const routes: Routes = [
    { path: '', redirectTo: 'buscar', pathMatch: 'full' },
    {path: 'novo', component: ManhwaForm},
    {path: 'buscar', component: ManhwaSearch},
    {path: 'resultados', component: ManhwaResult}
];
