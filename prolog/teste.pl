pessoa(joao, homem, 30).
pessoa(maria, mulher, 25).
pessoa(carlos, homem, 40).
animal(cachorro, mamifero).
animal(gato, mamifero).
animal(cobra, reptil).
gosta(joao, cachorro).
gosta(maria, gato).
gosta(carlos, cobra).

eh_adulto(Nome) :- 
    pessoa(Nome, _, Idade),
    Idade >= 18.

gosta_de_animal_de_estimacao(Nome) :-
    pessoa(Nome, _, _),
    (gosta(Nome, cachorro); gosta(Nome, gato)).

nao_eh_mamifero(TipoAnimal) :-
    animal(TipoAnimal, _),
    \+ animal(TipoAnimal, mamifero).