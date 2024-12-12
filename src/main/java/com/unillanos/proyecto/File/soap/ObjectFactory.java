//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.12.12 a las 09:21:56 AM COT 
//


package com.unillanos.proyecto.File.soap;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.unillanos.proyecto.File.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRootElement()
@XmlRegistry
public class ObjectFactory {

    private final static QName _Files_QNAME = new QName("http://services.soap.example.org/", "Files");
    private final static QName _File_QNAME = new QName("http://services.soap.example.org/", "file");
    private final static QName _GetFileList_QNAME = new QName("http://services.soap.example.org/", "getFileList");
    private final static QName _GetFileListResponse_QNAME = new QName("http://services.soap.example.org/", "getFileListResponse");
    private final static QName _GetFileUUID_QNAME = new QName("http://services.soap.example.org/", "getFileUUID");
    private final static QName _GetFileUUIDResponse_QNAME = new QName("http://services.soap.example.org/", "getFileUUIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unillanos.proyecto.File.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileListWrapper }
     * 
     */
    public FileListWrapper createFileListWrapper() {
        return new FileListWrapper();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link GetFileList }
     * 
     */
    public GetFileList createGetFileList() {
        return new GetFileList();
    }

    /**
     * Create an instance of {@link GetFileListResponse }
     * 
     */
    public GetFileListResponse createGetFileListResponse() {
        return new GetFileListResponse();
    }

    /**
     * Create an instance of {@link GetFileUUID }
     * 
     */
    public GetFileUUID createGetFileUUID() {
        return new GetFileUUID();
    }

    /**
     * Create an instance of {@link GetFileUUIDResponse }
     * 
     */
    public GetFileUUIDResponse createGetFileUUIDResponse() {
        return new GetFileUUIDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileListWrapper }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FileListWrapper }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "Files")
    public JAXBElement<FileListWrapper> createFiles(FileListWrapper value) {
        return new JAXBElement<FileListWrapper>(_Files_QNAME, FileListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link File }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link File }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "file")
    public JAXBElement<File> createFile(File value) {
        return new JAXBElement<File>(_File_QNAME, File.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileList }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "getFileList")
    public JAXBElement<GetFileList> createGetFileList(GetFileList value) {
        return new JAXBElement<GetFileList>(_GetFileList_QNAME, GetFileList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "getFileListResponse")
    public JAXBElement<GetFileListResponse> createGetFileListResponse(GetFileListResponse value) {
        return new JAXBElement<GetFileListResponse>(_GetFileListResponse_QNAME, GetFileListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileUUID }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileUUID }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "getFileUUID")
    public JAXBElement<GetFileUUID> createGetFileUUID(GetFileUUID value) {
        return new JAXBElement<GetFileUUID>(_GetFileUUID_QNAME, GetFileUUID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileUUIDResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileUUIDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.soap.example.org/", name = "getFileUUIDResponse")
    public JAXBElement<GetFileUUIDResponse> createGetFileUUIDResponse(GetFileUUIDResponse value) {
        return new JAXBElement<GetFileUUIDResponse>(_GetFileUUIDResponse_QNAME, GetFileUUIDResponse.class, null, value);
    }

}
