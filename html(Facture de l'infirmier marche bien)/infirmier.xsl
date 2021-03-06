<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : infirmier.xsl
    Created on : 18 octobre 2017, 11:47
    Author     : diallo1
    Description:
        Purpose of transformation follows.
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:ns1='http://www.ujf-grenoble.fr/l3miage/medical'
                xmlns:act="http://www.ujf-grenoble.fr/l3miage/actes">
    <xsl:output method="html"/>
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt     
    -->
    <!--Définition de la variable actes qui contient des noeuds ngap du document actes.xml-->
    <xsl:variable name="actes" select="document('actes.xml', /)/act:ngap"/>
    <!--Définition d'un parametre global destinedId-->
    <xsl:param name="destinedId" select="001"/>  
    <!--Définition de la variable visitesDuJour qui contient l'ensemble des noeud visite d'une infirmière-->
    <xsl:variable name="visitesDuJour" select="//ns1:visite[@intervenant=$destinedId and @date='2015-12-08']"/>
    <!--Template principale-->   
    <xsl:template match="/">
        <html>
            <head>
                <title>Page infirmier</title>
                <link rel="stylesheet" type="text/css" href="./css/infirmier.css"/>
                <script type="text/javascript" src="./js/facture.js"/> 
                <script type="text/javascript"> 
                    <!--Création de la fonction openFacture qui permet de generer une facture -->
                    <![CDATA[
                        function openFacture(prenom, nom, actes) {
                            var width  = 500;
                            var height = 300;
                            if(window.innerWidth) {
                                var left = (window.innerWidth-width)/2;
                                var top = (window.innerHeight-height)/2;
                            }
                            else {
                            var left = (document.body.clientWidth-width)/2;
                            var top = (document.body.clientHeight-height)/2;
                            }
                            var factureWindow = window.open('','facture','menubar=yes, scrollbars=yes, top='+top+', left='+left+', width=800, height=500');
                            factureText = afficherFacture(prenom, nom, actes);
                            factureWindow.document.write(factureText);
                        }        
                    ]]>
                </script>
            </head>
            <body>
                <!--Appelle de la template infirmier avec en paramettre l'identifiant de l'infirmière -->
                <xsl:call-template name="infirmier">
                    <xsl:with-param name="destinedId"/>
                </xsl:call-template>                                     
            </body>
        </html>
    </xsl:template>
    <!--Création de la template infirmier qui va permettre d'affiche les information d'une infirmière -->
    <xsl:template name="infirmier">
        <h1> Le voyageur de santé : IHM de la secrétaire</h1>
        <div class="page">
            <div class="infirmier">
                <div class="image">
                    <img src="image/{ns1:cabinet/ns1:infirmiers/ns1:infirmier[@id=$destinedId]/ns1:photo}" alt="Smiley face" width="100" height="100"/>
                </div>
                <div class="imagecabinet">
                    <img src="image/infirmiere.jpg" alt="Smiley face" width="100" height="100"/>
                </div>
                <div class="pres">
                    Bonjour <xsl:value-of select="ns1:cabinet/ns1:infirmiers/ns1:infirmier[@id=$destinedId]/ns1:prénom/text()"/>
                    <br/>
                    Aujourd'hui, vous avez <xsl:value-of select="count($visitesDuJour)"/> patients<br/> 
                </div>         
            </div> 
            <div class="patient">  
                <h2> Informations des Patients</h2>  
            </div>    
            <!--Création d'un tableau qui doit contenir les information des patients d'une infirmière -->
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Adresse</th>
                        <th>Soins</th>
                        <th>Facture</th>
                    </tr>
                </thead>
                <tbody>
                    <!--Appelle de template pour récupérer les information des patients d'une infirmière -->
                    <xsl:apply-templates select="ns1:cabinet/ns1:patients/ns1:patient"/>
                </tbody>
            </table>
        </div>        
    </xsl:template>
    <!--Template pour récupérer les information des patients d'une infirmière-->
    <xsl:template match="ns1:patient">
        <xsl:if test="ns1:visite[@intervenant=$destinedId and @date='2015-12-08']">
            <tr class="success">
                <td>
                    <span>
                        <xsl:value-of select="ns1:prénom"/> 
                    </span>
                    <span>
                        <xsl:value-of select="ns1:nom"/>
                    </span>
                </td>
                <td> 
                    <xsl:value-of select="ns1:adresse/ns1:étage/text()"/>
                    <xsl:if test="ns1:adresse/ns1:étage/text()">
                        ième Etage
                    </xsl:if>
                    <br/>
                    <br/>
                    <span >
                        <xsl:value-of select="ns1:adresse/ns1:numéro/text()"/>  
                    </span>
                    <span>
                        <xsl:value-of select="ns1:adresse/ns1:rue/text()"/>
                    </span>  
                    <br/>
                    <span>
                        <xsl:value-of select="ns1:adresse/ns1:codePostal/text()"/>
                    </span> 
                    <span>
                        <xsl:value-of select="ns1:adresse/ns1:ville/text()"/> 
                    </span>
                </td>       
                <td>
                    <!--Piocher les différents soins d'un patient à travers variable $actes contenant les noeuds ngap du document actes.xml--> 
                    <xsl:apply-templates select="ns1:visite/ns1:acte"/>
                    
                </td>
                <td>
                    <!--Création d'un element de type button dont la propriété onclick prend la fonction openFacture-->         
                    <xsl:element name="button">                   
                        <xsl:attribute name="onclick">
                            openFacture('<xsl:value-of select="ns1:prénom"/>', 
                            '<xsl:value-of select="ns1:nom"/>', 
                            '<xsl:value-of select="ns1:visite/ns1:acte"/>')
                        </xsl:attribute>   
                        Facture
                    </xsl:element>               
                    <br/>     
                </td>
            </tr> 
        </xsl:if>        
    </xsl:template> 
    <xsl:template match="ns1:acte">
        <xsl:variable name="idact" select="@id"/>
        <xsl:value-of select="($actes/act:actes/act:acte[@id=$idact]/text())"/> 
        <br/>       
    </xsl:template>    
</xsl:stylesheet>
