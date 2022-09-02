package kg.megacom.atm_service.models.dto.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AuthorizationRequest {
    Long clientId;
    int numberOfBankomat;
}
