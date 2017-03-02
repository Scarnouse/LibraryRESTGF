/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lolo
 */
@Entity
@Table(name = "READER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reader.findAll", query = "SELECT r FROM Reader r")
    , @NamedQuery(name = "Reader.findById", query = "SELECT r FROM Reader r WHERE r.id = :id")
    , @NamedQuery(name = "Reader.findByDni", query = "SELECT r FROM Reader r WHERE r.dni = :dni")
    , @NamedQuery(name = "Reader.findByName", query = "SELECT r FROM Reader r WHERE r.name = :name")
    , @NamedQuery(name = "Reader.findByLastName", query = "SELECT r FROM Reader r WHERE r.lastName = :lastName")
    , @NamedQuery(name = "Reader.findByBirthday", query = "SELECT r FROM Reader r WHERE r.birthday = :birthday")})
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToMany(mappedBy = "idReaderFk")
    private Collection<Book> bookCollection;

    public Reader() {
    }

    public Reader(Integer id) {
        this.id = id;
    }

    public Reader(Integer id, String dni, String name, String lastName, Date birthday) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reader)) {
            return false;
        }
        Reader other = (Reader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reader[ id=" + id + " ]";
    }
    
}
