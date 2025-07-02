import { Component, OnInit } from '@angular/core';
import { TabViewModule } from 'primeng/tabview';
import { SifarnikComponent } from "../../admin-components/sifarnik/sifarnik.component";
import { ARegKorisniciComponent } from "../../admin-components/a-reg-korisnici/a-reg-korisnici.component";
import { AStudijskiProgramiComponent } from "../../admin-components/a-studijski-programi/a-studijski-programi.component";
import { AOrganizacijaComponent } from "../../admin-components/a-organizacija/a-organizacija.component";
import { AZaposleniComponent } from "../../admin-components/a-zaposleni/a-zaposleni.component";

@Component({
  selector: 'app-e-admin',
  standalone: true,
  imports: [TabViewModule, SifarnikComponent, ARegKorisniciComponent, AStudijskiProgramiComponent, AOrganizacijaComponent, AZaposleniComponent],
  templateUrl: './e-admin.component.html',
  styleUrl: './e-admin.component.css'
})
export class EAdminComponent implements OnInit{

  selectedTabIndex: number = 0;

  ngOnInit(): void {
    const savedIndex = localStorage.getItem('selectedTabIndex');
    if (savedIndex) {
      this.selectedTabIndex = +savedIndex;
    }else{
      this.selectedTabIndex = 0;
    }
  }

  onTabChange(event: any) {
    localStorage.setItem('selectedTabIndex', event.index);
  }

}
