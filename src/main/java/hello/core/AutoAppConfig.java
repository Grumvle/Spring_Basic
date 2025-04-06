package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
//        basePackages = "hello.core",
//        basePackageClasses = AutoAppConfig.class,
        // 위의 두개를 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        // 권장: 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것이다. 스프링 부트도 이 방법을 기본으로 제공한다.
        // 프로젝트 메인 설정정보는 프로젝트를 대표하는 정보이기 때문에 프로젝트 시작 루트 위치에 두는 것이 좋다고 본다.
        // 스프링 부트를 사용하는 경우 스프링 부트 대표 시작정보인 `@SpringBootApplication`를 이 프로젝트 시작 루트 위치에 두는 것이 관례이다. (그리고 이 설정에 @ComponentScan 이 들어있다.)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // @Configuration 정의를 보면 @Component 가 붙어있다
        // 예제코드를 남기기위해 필터를 추가함
)
// @Component 애노테이션이 붙은것들을 자동으로 스프링 빈으로 등록해준다.
public class AutoAppConfig {

/*  수동으로 주입 시에 중복일 경우 스프링 부트에서는 오류가 발생한다.
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}

/*
컴포넌트 스캔은 @Component 뿐만 아니라 아래의 것도 스캔한다.
@Component
@Controller
@Service
@Repository
@Configuration

@Controller 스프링 MVC 컨트롤러로 인식
@Repository 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
@Configuration 스프링 설정 정보를 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 함.
@Service 이건 특별한 처리를 하지 않음. 대신 개발자가 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는ㄷ네 도움이 된다.
 */