# ⭐🎬Celebrity Finder⭐🎬

Ce programme permet d'identifier les célébrités lors d'un événement.
Une célébrité est définie comme une personne connue de tout le monde, mais qui **ne connaît aucune autre célébrité**.

---

## Table des matières

* Installation
* Utilisation
* Règles du programme
* Fonctionnalités
* Structure du code

---

## Installation

Assurez-vous d'avoir **Java 8 ou supérieur** installé sur votre machine.
Téléchargez le fichier `Main.java` dans le répertoire de votre choix.

Pour compiler et exécuter le programme depuis le terminal :

```bash
javac Main.java
java Main
```

---

## Utilisation

Le programme crée une liste d'invités et vérifie qui parmi eux est une célébrité.

* Les invités sont définis par un identifiant, un nom et la liste des personnes qu'ils connaissent.
* Le programme affiche ensuite les célébrités identifiées.

Exemple de sortie :

```
Les célébrités sont Françoise, ...
```

---

## Règles du programme

1. Une célébrité doit être **connue par tout le monde**.
2. Une célébrité **doit uniquement connaitre d'autres célébrité**.
3. Le programme vérifie ces conditions pour chaque invité et affiche uniquement ceux qui les respectent.

---

## Fonctionnalités

* Gestion dynamique des invités avec leurs relations de connaissance.
* Détection automatique des célébrités selon les règles ci-dessus.
* Supporte n'importe quelle taille de groupe d'invités.
* Affichage clair des résultats dans la console.

---

## Structure du code

* `createInvitedPerson(int number, String name, int... knownPeople)` : Ajoute une personne avec la liste des personnes qu'elle connaît.
* `findCelebrities(Map<Integer, Map.Entry<String, int[]>> invitedPeopleList)` : Détermine les célébrités dans la liste d'invités.
* `convertPrimitiveListToOOP(int[] primitiveList)` : Convertit un tableau primitif en `List<Integer>` pour faciliter la vérification des relations.
* `main(String[] args)` : Initialise les invités, trouve les célébrités et les affiche.


---
## Notes

* Le programme fonctionne uniquement avec des **identifiants uniques pour chaque invité**.
* Les relations doivent être correctement renseignées pour obtenir un résultat exact.
