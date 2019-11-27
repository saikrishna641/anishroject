insert into TEST_CUSTOMER (ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL, PASSWORD, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (1, 'Rama', 'D', to_date('07-08-1986', 'dd-mm-yyyy'), 'rama.d@gmail.com', 'test123', 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0);

insert into TEST_TRAVELLER (ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, CUSTOMER_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION, MIDDLE_NAME, PASSPORT_NUMBER)
values (2, 'Laxman', 'D', to_date('15-11-1989', 'dd-mm-yyyy'), 1, 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0, null, null);
insert into TEST_TRAVELLER (ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, CUSTOMER_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION, MIDDLE_NAME, PASSPORT_NUMBER)
values (1, 'Rama', 'D', to_date('07-08-1986', 'dd-mm-yyyy'), 1, 'online@flightsbooking.com', to_date('17-11-2019 23:43:01', 'dd-mm-yyyy hh24:mi:ss'), 3, null, null);

insert into Test_Flights (ID, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, BASE_FARE, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (4, 'MAA', 'DXB', to_date('03-12-2019 03:30:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2019 06:20:00', 'dd-mm-yyyy hh24:mi:ss'), 435.00, 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0);
insert into Test_Flights (ID, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, BASE_FARE, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (3, 'MAA', 'DXB', to_date('02-12-2019 09:45:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 12:40:00', 'dd-mm-yyyy hh24:mi:ss'), 435.00, 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0);
insert into Test_Flights (ID, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, BASE_FARE, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (1, 'MAA', 'DXB', to_date('02-12-2019 00:20:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 09:50:00', 'dd-mm-yyyy hh24:mi:ss'), 100.00, 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0);
insert into Test_Flights (ID, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, BASE_FARE, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (2, 'MAA', 'DXB', to_date('02-12-2019 03:30:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 06:20:00', 'dd-mm-yyyy hh24:mi:ss'), 435.00, 'online@flightsbooking.com', to_date('16-11-2019', 'dd-mm-yyyy'), 0);

insert into TEST_FLIGHT_SEGMENT (ID, FLIGHT_NUMBER, OPERATING_AIRLINES, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, FLIGHT_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (1, '6E 6217', 'Indigo', 'MAA', 'BLR', to_date('02-12-2019 00:20:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 01:30:00', 'dd-mm-yyyy hh24:mi:ss'), 1, 'online@flightsbooking.com', to_date('17-11-2019', 'dd-mm-yyyy'), 0);
insert into TEST_FLIGHT_SEGMENT (ID, FLIGHT_NUMBER, OPERATING_AIRLINES, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, FLIGHT_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (2, '6E 95', 'Indigo', 'BLR', 'DXB', to_date('02-12-2019 07:20:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 09:50:00', 'dd-mm-yyyy hh24:mi:ss'), 1, 'online@flightsbooking.com', to_date('17-11-2019', 'dd-mm-yyyy'), 0);
insert into TEST_FLIGHT_SEGMENT (ID, FLIGHT_NUMBER, OPERATING_AIRLINES, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, FLIGHT_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (3, 'EK545', 'Emirates', 'MAA', 'DXB', to_date('02-12-2019 09:45:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 12:40:00', 'dd-mm-yyyy hh24:mi:ss'), 3, 'online@flightsbooking.com', to_date('17-11-2019', 'dd-mm-yyyy'), 0);
insert into TEST_FLIGHT_SEGMENT (ID, FLIGHT_NUMBER, OPERATING_AIRLINES, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, FLIGHT_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (4, 'EK545', 'Emirates', 'MAA', 'DXB', to_date('03-12-2019 03:30:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2019 06:20:00', 'dd-mm-yyyy hh24:mi:ss'), 4, 'online@flightsbooking.com', to_date('17-11-2019', 'dd-mm-yyyy'), 0);
insert into TEST_FLIGHT_SEGMENT (ID, FLIGHT_NUMBER, OPERATING_AIRLINES, SOURCE, DESTINATION, DEPARTURE_DATE, ARRIVAL_DATE, FLIGHT_ID, LAST_UPDATED_BY, LAST_UPDATED, OPTLOCK_VERSION)
values (5, 'EK545', 'Emirates', 'MAA', 'DXB', to_date('02-12-2019 03:30:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-12-2019 06:20:00', 'dd-mm-yyyy hh24:mi:ss'), 2, 'online@flightsbooking.com', to_date('17-11-2019', 'dd-mm-yyyy'), 0);
