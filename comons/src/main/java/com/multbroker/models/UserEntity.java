package com.multbroker.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * 
 * Entidade responsável pelos dados de usuário
 * 
 * @author fred
 * @email  dfredmota@gmail.com
 *
 */

@Builder
@Entity
@Table(name="users",schema = "multbroker")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@EqualsAndHashCode
@ToString
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 7495355226884271607L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_users")
	@SequenceGenerator(name = "sq_users", sequenceName = "sq_users", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String encryptedPassword;

    @Column(name = "nome_completo", length = 50)
    private String nomeCompleto;

    @Column(length = 254, unique = true)
    private String email;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private boolean activated = false;

    @Column(name = "image_url", length = 256)
    private String imageUrl;
    
    @Column(name = "activation_key", length = 20)
    private String activationKey;
    
    @Column(name = "reset_key", length = 20)
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate = null;
    
    @Column(name = "lang_key", length = 6)
    private String langKey;

    public UserEntity(){
    }

    public UserEntity(Long id, String encryptedPassword, String nomeCompleto, String email, String cpf, boolean activated, String imageUrl, String activationKey, String resetKey, Instant resetDate, String langKey) {
        super();
        this.id = id;
        this.encryptedPassword = encryptedPassword;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.activated = activated;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.resetKey = resetKey;
        this.resetDate = resetDate;
        this.langKey = langKey;
    }
}
