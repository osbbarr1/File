//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.12.08 a las 08:23:37 PM COT 
//


package com.unillanos.proyecto.File.soap;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Clase Java para fileListWrapper complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="fileListWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="file" type="{http://services/}fileDTO" minOccurs="0"/&gt;
 *         &lt;element name="fileList" type="{http://services/}fileDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileListWrapper", propOrder = {
    "file",
    "fileList"
})
public class FileListWrapper {

    protected FileDTO file;
    @XmlElement(nillable = true)
    protected List<FileDTO> fileList;

    /**
     * Obtiene el valor de la propiedad file.
     * 
     * @return
     *     possible object is
     *     {@link FileDTO }
     *     
     */
    public FileDTO getFile() {
        return file;
    }

    /**
     * Define el valor de la propiedad file.
     * 
     * @param value
     *     allowed object is
     *     {@link FileDTO }
     *     
     */
    public void setFile(FileDTO value) {
        this.file = value;
    }

    /**
     * Gets the value of the fileList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileDTO }
     * 
     * 
     */
    public List<FileDTO> getFileList() {
        if (fileList == null) {
            fileList = new ArrayList<FileDTO>();
        }
        return this.fileList;
    }

}
