package top.zbeboy.zone.hystrix.platform;

import org.springframework.stereotype.Component;
import top.zbeboy.zone.domain.tables.pojos.UsersType;
import top.zbeboy.zone.feign.platform.UsersTypeService;

@Component
public class UsersTypeFeignHystrixClientFallbackFactory implements UsersTypeService {
    @Override
    public UsersType findById(int id) {
        return new UsersType();
    }

    @Override
    public UsersType findByUsersTypeName(String usersTypeName) {
        return new UsersType();
    }
}
