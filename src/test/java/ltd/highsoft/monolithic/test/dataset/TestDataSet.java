package ltd.highsoft.monolithic.test.dataset;

import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestDataSet implements InitializingBean {

    private @Resource AccessTokenRepository accessTokenRepository;

    @Override
    public void afterPropertiesSet() {
        accessTokenRepository.save(Tester.ACCESS_TOKEN);
    }

}
