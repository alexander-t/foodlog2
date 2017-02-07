UPDATE FOOD SET category='SAUSAGE' WHERE name = 'Kabanoss - Classic';
UPDATE FOOD SET category='SAUSAGE' WHERE name = 'Ölkorv - Red Devil';
UPDATE FOOD SET unit_weight=60, unit_label='st', category='DAIRY', pack_size_in_grams=NULL WHERE name = 'Ägg';
UPDATE FOOD SET unit_weight=22, unit_label='kaka', category='COOKIES',name='Cookies fyllda - Kola & Chocklad' WHERE name LIKE 'Cookies fyllda - Kola & Chocklad%';
UPDATE FOOD SET unit_weight=5, unit_label='skiva', name='Pepparsalami' WHERE name LIKE 'Pepparsalami %';
UPDATE FOOD SET unit_weight=17, unit_label='bulle', category='FROZEN', name='Grönsaksbullar' WHERE name LIKE 'Grönsaksbullar%';
UPDATE FOOD SET unit_weight=50, unit_label='skiva', name='Proteinbröd' WHERE name LIKE 'Proteinbröd%';

