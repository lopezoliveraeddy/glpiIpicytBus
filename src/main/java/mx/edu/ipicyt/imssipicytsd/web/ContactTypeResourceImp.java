package mx.edu.ipicyt.imssipicytsd.web;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.ContactType;
import mx.edu.ipicyt.imssipicytsd.repository.ContactTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class ContactTypeResourceImp {
    private final Logger log = LoggerFactory.getLogger(ContactTypeResourceImp.class);
    private static final String ENTITY_NAME = "contactType";
    private final ContactTypeRepository contactTypeRepository;

    public ContactTypeResourceImp(ContactTypeRepository contactTypeRepository) {
        this.contactTypeRepository = contactTypeRepository;
    }

    /**
     * GET  /contact-types/:contactTypeRemedy : get the "id" contactType.
     *
     * @param contactTypeRemedy the contactTypeRemedy of the contactType to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the contactType, or with status 404 (Not Found)
     */
    @GetMapping("/contact-types/remedy/{contactTypeRemedy}")
    @Timed
    public ResponseEntity<ContactType> getContactTypeRemedy(@PathVariable String contactTypeRemedy) {
        log.debug("REST request to get ContactType : {}", contactTypeRemedy);
        ContactType contactType = contactTypeRepository.findContactTypeByContactTypeRemedy(contactTypeRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(contactType));
    }
}
