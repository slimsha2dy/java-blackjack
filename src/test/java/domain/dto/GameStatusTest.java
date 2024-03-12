package domain.dto;

import domain.Dealer;
import domain.Name;
import domain.Player;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStatusTest {
    @Test
    @DisplayName("List<GamerDto>로 생성한다.")
    void create() {
        Assertions.assertThatCode(() -> new GameStatus(
                new Dealer(),
                List.of(new Player(new Name("test")))
        )).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("List<GamerDto>를 반환한다.")
    void getGamerDtos() {
        GameStatus gameStatus = new GameStatus(
                new Dealer(),
                List.of(new Player(new Name("test")))
        );
        Assertions.assertThat(gameStatus.getGamerDtos().get(0).getName())
                .isEqualTo("test");
    }

    @Test
    @DisplayName("이름이 들어오면 GamerDto를 반환한다.")
    void getGamerDtoFromName() {
        GameStatus gameStatus = new GameStatus(
                new Dealer(),
                List.of(new Player(new Name("test")))
        );
        Assertions.assertThat(gameStatus.getGamerDtoFromName("test").getName())
                .isEqualTo("test");
    }

    @Test
    @DisplayName("없는 이름이 들어오면 예외를 발생한다.")
    void getGamerDtoFromNameException() {
        GameStatus gameStatus = new GameStatus(
                new Dealer(),
                List.of(new Player(new Name("test")))
        );
        Assertions.assertThatThrownBy(() -> gameStatus.getGamerDtoFromName("wrongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 참여자 입니다.");
    }
}
