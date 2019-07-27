package testTeretana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import testTeretana.domain.Clan;
import testTeretana.domain.QClan;

public interface ClanDao extends JpaRepository<Clan, Long>, 
QuerydslPredicateExecutor<Clan>, QuerydslBinderCustomizer<QClan> {

	@Override
	default void customize(QuerydslBindings bindings, QClan root) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	}

}
