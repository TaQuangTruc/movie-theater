package __NotFound.movie_theater.Config;

import __NotFound.movie_theater.Exception.AppException;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring", // Áp dụng Spring làm component model cho tất cả các mapper
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE // Bỏ qua các giá trị null khi ánh xạ
)
public interface CommonMapperConfig {
}
