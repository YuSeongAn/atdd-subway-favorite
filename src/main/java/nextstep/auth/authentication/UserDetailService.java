package nextstep.auth.authentication;

import nextstep.member.domain.LoginMember;

@FunctionalInterface
public interface UserDetailService {
    LoginMember loadUserByUsername(String username);
}