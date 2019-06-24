# hotel-booking
Technologia: Spring Boot
Portal zajmujący się obsługą rezerwacji pokoi hotelowych.

API portalu wystawione w oparciu o usługi REST.

Dostępne są następujące usługi:
1. Lista dostępnych pokoi
2. Zarezerwowanie pokoju
3. Usunięcie rezerwacji

Dodatkowo 1 dzień przed rezerwacją system powiadamia o zbliżającym się terminie rezerwacji.

Do portalu jest dołączony klient(może być uruchamiany z testu jednoskowego), który integruje się ze wskazanymi usługami. Klient pozwala na realizację scenariusza:
1. Podejrzenie listy dostępnych pokoi.
2. Zarezerwowanie pokoju.
3. Anulowanie zarezerwowanego pokoju w punkcie 2. 
