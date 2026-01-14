# XML
Librairie qui gère des traitements sur les XML.

# Comment l'utiliser ?
Etendre la classe :
```java
import com.phenix.xml.XML;
```

Exemple :

```java
import com.phenix.xml.XML;
import jakarta.validation.constraints.NotNull;

public class XMLFile extends XML {
    public XMLFile(@NotNull File fichier) {
        // Le fichier à analyser.
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.fichier);

        // La racine du document (projet).
        Element racine = document.getDocumentElement();

        // Puis on peut utiliser les fonctions statiques :
        Node nodeParent = getNodeByName(racine, "parent");
        // ...
    }
}
```