# Zadanie dla was, moi drodzy brzmi następująco:

1. Korzystając z wiedzy, którą zdobyłeś na kursie, wytwórz kilka kontrolerów   
a) UserController (Restowy kontroler)   
b) ApplicationController (Restowy kontroler)  
c) AddressController (Restowy kontroler)

2. W każdym z tych kontrolerów powinna być podana ścieżka (@RequestMapping) w taki sposób, aby łatwo było się dowiedzieć, co to za kontroler.
3. Każdy z tych kontrolerów powinien zawierać 4 metody restowe (GET, POST, DELETE, PATCH), zgodnie z ich przeznaczeniem
4. Stwórz serwisy oraz repozytoria (jeżeli dasz radę, to może być z użyciem hibernate), które będą te kontroley obsługiwały
5. Powyższe serwisy i repozytoria powinny mieć możliwość dodawania, usuwania, zmieniania i wyciągania z nich danych (oczywiście odpowiednio od danego elementu)

(Tutaj musicie pamiętać, że nie wszystko jest opisane).

6. Dobrze by było, gdybyście zrobili profile, oraz propertiesy. Propertiesy najlepiej na ścieżki dla kontrolerów. Możecie dodać również swoje właśne propertiesy
7. Połączcie Address i Usera w taki sposób, aby User posiadał w sobie Address, a za pomocą Addressu można było wyjąc wszystkich userów z tym addressem
8. Połączcie jakoś Application i usera.
9. Dodaj możliwość usuwania kaskadowego ze wszystkich trzech repozytoriów.


#****
#Jeżeli bardzo chcesz, to możesz do tego wytworzyć aplikację reactową, która to będzie wspomagała.

#POWODZENIA

Poniżej pomoce, które mogą się przydać :)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

