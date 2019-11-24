insert into user(id, first_name, last_name, pesel) values
  (1, 'Jan', 'Kowalski', '90101222457'),
  (2, 'Maciej', 'Zalewski', '87112242456'),
  (3, 'Aneta', 'Korczyńska', '76061536749'),
  (4, 'Wojciech', 'Sokolik', '82010877245');

insert into category(id, name, description) values
  (1, 'Laptopy', 'Przenośne komputery osobiste'),
  (2, 'Telefony', 'Drobny sprzęt komputerowy'),
  (3, 'Pojazdy', 'Samochody i skutery');

insert into asset(id, name, description, serial_number, category_id) values
  (1, 'Asus MateBook D', '15 calowy laptop, i5, 8GB DDR3, kolor czarny', 'ASMBD198723', 1),
  (2, 'Apple MacBook Pro 2015', '13 calowy laptop, i5, 16GB DDR3, SSD256GB, kolor srebrny', 'MBP15X0925336', 1),
  (3, 'Dell Inspirion 3576', '13 calowy laptop, i7, 8GB DDR4, SSD 512GB, kolor czarny', 'DI3576XO526716', 3),
  (4, 'Lenovo Thinkpad X1 Carbon', '14 calowy laptop, i5, 8GB DDR4, SSD 128GB, kolor czarny', 'LTX1C8KA78220', 1),
  (5, 'Samsung Note 8', 'Kompletny zestaw: telefon, słuchawki, rysik, ładowarka', 'SN882017AX896B', 2),
  (6, 'Xiaomi Mi Mix 2', 'Telefon z ładowarką', 'XMM2S78A6652J', 2),
  (7, 'Apple iPhone X', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'APLX17287GHX21', 2),
  (8, 'Apple iPhone 8', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'APL8185652HGT7', 2),
  (9, 'Opel Insignia GSi', 'Samochód osobowy, 6 biegowa automatyczna skrzynia biegów, benzynowy silnik 2.0', 'XHG78K64', 3),
  (10, 'Ford Focus', 'Samochód osobowy, 5 biegowa manualna skrzynia biegów, silnik diesel 1.6', 'M24HP88GYJ', 3);
  
insert into assignment(id, start, end, asset_id, user_id) values
  (1, '2017-10-08 15:00:00', '2018-10-08 15:00:00', 1, 1),
  (2, '2018-10-09 12:00:00', null, 5, 1),
  (3, '2018-10-10 16:00:00', null, 9, 1);