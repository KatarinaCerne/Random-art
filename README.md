# RANDOM ART #

Random Art je program, ki riše abstraktne umetniške slike. (več informacij na  http://math.andrej.com/2010/04/21/random-art-in-python/)

### Čemu je ta repozitorij namenjen? ###

* Repozitorij vsebuje program Random Art - projekt pri predmetu Programiranje 2 v šolskem letu 2014/2015.
* Cilj je ustvariti program, ki naključno izbira med operatorji in s pomočjo njih izračuna in nariše abstraktno sliko

### Kaj repozitorij vsebuje? ###

Znotraj mape R.Art je src, ki vsebuje:

* `GlavniProgram.java`
* `GlavnoOkno.java`- vsebuje vse v zvezi z grafičnim vmesnikom
* `Slika.java` - vsebuje funkcije za računanje, risanje in preoblikovanje slike
* paket `operatorji`- vsebuje abstraktni razred `Operator.java` in podrazrede z operatorji, ki se uporabljajo pri računanju slike

### Kako program uporabljamo? ###
* ko zaženemo program, se nariše naključna slika
* če pritisnemo gumb `Še enkrat!` se nariše nova slika
* z gumbom `Siva!`sliko spremenimo iz barvne v sivo (greyscale)
* z gumbom `Črno-bela` sliko spremenimo iz barvne v črno in belo
* če pritisnemo na gumb `Shrani`, sliko lahko shranimo v formatu png
* z gumbom `Razveljavi spremembe` razveljavimo vse spremembe, ki smo jih naredili na sliki po tistem, ko se je narisala
* s sliderjem za svetlost spreminjamo svetlost slike
* s sliderji za rdečo, zeleno in modro spreminjamo vsebnost navedenih barv
* črno-beli sliki ne moremo spreminjati svetlosti
* črno-beli in sivi sliki ne moremo spreminjati vsebnosti barv