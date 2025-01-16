package com.phenix.xml;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Traitement sur un XML générique.<br>
 * Cela ajoute des fonctions très utiles pour traiter un XML.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public abstract class XML {

    /**
     * Retourne le node enfant via son nom.
     *
     * @param list Le node où on doit chercher.
     * @param name String Nom du node à trouver.
     * @return Retourne le node demandé, sinon retourne {@code null} s'il ne
     * trouve pas.
     */
    @Null
    protected static NodeList getNodeListByName(@NotNull NodeList list, String name) {
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals(name)) {
                return ((Element) list.item(i)).getChildNodes();
            }
        }

        return null;
    }

    /**
     * Retourne une liste de node enfant via son nom.<br>
     * Donc il existe plusieurs noms enfant portant le même nom.
     *
     * @param node Le node parent.
     * @param name Nom du node à trouver.
     * @return Retourne une liste des nodes trouvé.
     */
    @NotNull
    protected static ArrayList<Node> getChildNodeListByName(@NotNull Node node, String name) {
        ArrayList<Node> liste_node = new ArrayList<Node>();
        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals(name)) {
                liste_node.add(list.item(i));
            }
        }

        return liste_node;
    }

    /**
     * Retourne la valeur d'un attribut d'un node selon son nom.
     *
     * @param node Node dont on veut la valeur.
     * @param name Nom de l'attribut.
     * @return Valeur de l'attribut.
     */
    protected static String getAttributValueByName(@NotNull Node node, String name) {
        return node.getAttributes().getNamedItem(name).getNodeValue();
    }

    /**
     * Retourne un {@code Node} selon son nom dans un {@code Node} parent.
     *
     * @param node Le node où faire la recherche.
     * @param nom_node Le nom du node.
     * @return Le node recherché sinon {@code null}.
     */
    @Null
    protected static Node getChildNodeByName(@NotNull Node node, String nom_node) {
        NodeList liste_enfant = node.getChildNodes();

        for (int i = 0; i < liste_enfant.getLength(); i++) {
            if (liste_enfant.item(i).getNodeName().equals(nom_node)) {
                return liste_enfant.item(i);
            }
        }

        return null;
    }

    /**
     * Retourne le node enfant via son nom.
     *
     * @param node Le node parent.
     * @param name Nom du node enfant.
     * @return Le node sinon retourne {@code null} s'il ne trouve pas.
     */
    @Null
    protected static Node getNodeByName(@NotNull Node node, String name) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals(name)) {
                return list.item(i);
            }
        }

        return null;
    }

    /**
     * Retourne la valeur (contenu dans le node pas l'attribut 'value') d'un
     * node enfant.
     *
     * @param node Node parent.
     * @param name Nom du node enfant.
     * @return La valeur.
     */
    @Null
    protected static String getNodeValueByName(@NotNull Node node, String name) {
        Node child = getNodeByName(node, name);
        if (child != null) {
            return child.getTextContent();
        } else {
            return null;
        }
    }
}
