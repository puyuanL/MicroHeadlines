package common;

import lombok.Getter;

/**
 * return Result Information Class
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed"),
    PUBLISH_ERROR(506,"publishError"),
    FIND_HID_ERROR(507,"findHidError"),
    UPDATE_ERROR(508,"updateError"),
    DELETE_ERROR(509,"deleteError"),
    ;

    private final Integer code;
    private final String message;
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}