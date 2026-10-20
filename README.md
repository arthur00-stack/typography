# Typographie

Petit projet Java de composition typographique. Il représente le texte sous forme de boîtes mesurables, assemble ces boîtes horizontalement ou verticalement, puis dessine le résultat dans une fenêtre Swing.

Le projet illustre un modèle de mise en page simple : les glyphes ont une largeur et des métriques verticales, tandis que les espaces peuvent avoir une capacité d’étirement. Une ligne peut ainsi répartir l’espace disponible entre ses éléments extensibles.

## Fonctionnalités

- Mesure et dessin de glyphes à partir des polices AWT.
- Espaces fixes et espaces extensibles.
- Composition horizontale avec `Hbox` et verticale avec `Vbox`.
- Répartition de l’espace supplémentaire entre les éléments extensibles d’une ligne.
- Affichage dans une fenêtre Swing, avec des repères de marge et de largeur du texte.
- Signalement dans la console lorsqu’une boîte dépasse la largeur disponible.

La composition reste volontairement élémentaire : les retours à la ligne sont fournis explicitement, et le projet ne réalise pas de césure ni de retour automatique à la ligne.

## Prérequis

- Un JDK Java installé, avec `javac` et `java` accessibles depuis le terminal. Java 8 ou supérieur convient au code présent.
- Un environnement graphique pour afficher la fenêtre Swing.

Aucune bibliothèque externe n’est nécessaire.

## Compilation et lancement

Depuis la racine du projet :

```sh
mkdir -p bin
javac -d bin src/typo/*.java
java -cp bin typo.Test
```

La classe `typo.Test` lance actuellement l’exemple `test8a()`. Une fenêtre affiche un court texte français composé sur plusieurs lignes. Appuyez sur `Échap` pour fermer la fenêtre. Les éventuels messages de dépassement de largeur apparaissent dans le terminal.

Si la fenêtre ne s’ouvre pas sous Linux, vérifiez que la session dispose d’un serveur graphique et que Java n’est pas lancé en mode headless.

## Organisation du code

Les sources sont dans `src/typo/` et appartiennent au package Java `typo`.

| Classe | Rôle |
| --- | --- |
| `Box` | Contrat commun : dimensions, capacité d’étirement et dessin. |
| `Glyph` | Boîte représentant un caractère dessiné avec une police AWT. |
| `Space` | Espace de largeur minimale et de capacité d’étirement. |
| `FixedSpace` | Espace non extensible. |
| `RelativeSpace` | Espace extensible dont la largeur minimale dépend de la taille de la police. |
| `Group` | Base des compositions contenant une liste de boîtes. |
| `Hbox` | Composition horizontale ; distribue l’espace supplémentaire selon les capacités d’étirement. |
| `Vbox` | Composition verticale ; empile les boîtes en tenant compte de l’interligne. |
| `Page` | Composant Swing qui dessine une boîte dans une fenêtre. |
| `Test` | Exemples de construction et point d’entrée de la démonstration. |
| `TestableGroup` | Groupe auxiliaire utilisé pour les essais. |

Les constructeurs de `Glyph`, `Space`, `FixedSpace`, `RelativeSpace` et `Vbox` ne sont pas publics. Pour construire ces objets depuis une autre classe, placez celle-ci dans le package `typo` ou adaptez la visibilité des constructeurs.

## Construire une ligne

`Test.lineFromString(Font, String)` crée une `Hbox` caractère par caractère. Les espaces du texte deviennent des espaces extensibles de largeur minimale égale à la moitié de la taille de la police. Entre deux caractères non séparés par une espace, la méthode ajoute un espace fixe de 2 unités.

`Test.fromString(Font, String)` sépare le texte sur les retours à la ligne et place les lignes dans une `Vbox` avec un interligne de 5 unités. Un espace extensible supplémentaire est ajouté à la dernière ligne.

Pour modifier l’exemple lancé, changez l’appel dans `Test.main`, ou construisez une `Box` et passez-la à `new Page(box, largeur)` (hauteur par défaut : 300) ou à `new Page(box, largeur, hauteur)`.

## Essais

Le projet ne contient pas de suite de tests automatisés. `Test` regroupe plusieurs méthodes d’essai manuelles ; seule `test8a()` est appelée par le `main` actuel. Les autres méthodes peuvent être lancées en changeant temporairement cet appel.
