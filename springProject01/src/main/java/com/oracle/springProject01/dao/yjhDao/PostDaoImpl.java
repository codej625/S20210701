package com.oracle.springProject01.dao.yjhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.springProject01.model.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private SqlSession session;

//	게시물 갯수 가져오기
	@Override
	public int total(Post post) {
		System.out.println("PostDaoImpl int total() start...");
		int tot = 0;
		try {
			tot = session.selectOne("total",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int total Exception->" + e.getMessage());
		}
		return tot;
	}

//	게시물 리스트 가져오기
	@Override
	public List<Post> listPost(Post post) {
		System.out.println("PostDaoImpl List<Post> listPost() start...");
		List<Post> postList = null;
		try {
			postList = session.selectList("postList",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl List<Post> listPost() Exception->"+e.getMessage());
		}
		return postList;
	}

//	로그인되어있는 아이디 가져오기
	@Override
	public Post registerMember(Post post) {
		System.out.println("PostDaoImpl registerMember start...");
		Post registerMember = null;
		try {
			registerMember = session.selectOne("registerMember",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl registerMember Exception->"+e.getMessage());
		}
		return registerMember;
	}

//	게시물 작성하기
	@Override
	public int postInsert(Post post) {
		System.out.println("PostDaoImpl int postInsert start...");
		int result = 0;
		try {
			result = session.insert("postInsert",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postInsert Exception->"+e.getMessage());
		}
		return result;
	}
	
//	신청했는지 안했는지 확인
	@Override
	public int regInfoCheck(Post post) {
		System.out.println("PostDaoImpl regInfoCheck start...");
		int result = 0;
		try {
			result = session.selectOne("regInfoCheck",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl regInfoCheck Exception->"+e.getMessage());
		}
		return result;
	}
	
//	게시물을 찜 했는지 안했는지 확인
	@Override
	public int bookmarkCheck(Post post) {
		System.out.println("PostDaoImpl bookmarkCheck start...");
		int result = 0;
		try {
			result = session.selectOne("bookmarkCheck",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl bookmarkCheck Exception->"+e.getMessage());
		}
		return result;
	}

//	조회수 증가
	@Override
	public int postHit(Post post) {
		System.out.println("PostDaoImpl int postHit start...");
		int result = 0;
		try {
			result = session.update("postHit",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postHit Exception->"+e.getMessage());
		}
		return result;
	}
	
//	게시물 내용보기
	@Override
	public Post postListDetail(Post post) {
		System.out.println("PostDaoImpl Post postListDetail start...");
		Post post1 = new Post();
		try {
			post1 = session.selectOne("postListDetail",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl Post postListDetail Exception->"+e.getMessage());
		}
		return post1;
	}

//	게시물 수정하기
	@Override
	public int postListUpdate(Post post) {
		System.out.println("PostDaoImpl int postListUpdate start...");
		int result = 0;
		try {
			result = session.update("postListUpdate", post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postListUpdate Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 삭제
	@Override
	public int postDelete(Post post) {
		System.out.println("PostDaoImpl int postDelete start...");
		int result = 0;
		try {
			result = session.delete("postDelete",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl int postListUpdate Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 신청하기
	@Override
	public int postRegInfoInsert(Post post) {
		System.out.println("PostDaoImpl postRegInfoInsert start...");
		int result = 0;
		try {
			result = session.insert("postRegInfoInsert",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postRegInfoInsert Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 신청하면 p_capa값 마이너스 해주기
	@Override
	public int postCapaMinusUpdate(Post post) {
		System.out.println("PostDaoImpl postCapaMinusUpdate start...");
		int result = 0;
		try {
			result = session.update("postCapaMinusUpdate",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postCapaMinusUpdate Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 신청 취소하기
	@Override
	public int postRegInfoDelete(Post post) {
		System.out.println("PostDaoImpl postRegInfoDelete start...");
		int result = 0;
		try {
			result = session.delete("postRegInfoDelete",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postRegInfoDelete Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 신청하면 p_capa값 플러스 해주기
	@Override
	public int postCapaPlusUpdate(Post post) {
		System.out.println("PostDaoImpl postCapaPlusUpdate start...");
		int result = 0;
		try {
			result = session.update("postCapaPlusUpdate",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postCapaPlusUpdate Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 찜하기
	@Override
	public int postBookmarkInsert(Post post) {
		System.out.println("PostDaoImpl postBookmarkInsert start...");
		int result = 0;
		try {
			result = session.insert("postBookmarkInsert",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postBookmarkInsert Exception->"+e.getMessage());
		}
		return result;
	}

//	게시물 찜 취소하기
	@Override
	public int postBookmarkDelete(Post post) {
		System.out.println("PostDaoImpl postBookmarkDelete start...");
		int result = 0;
		try {
			result = session.delete("postBookmarkDelete",post);
		} catch (Exception e) {
			System.out.println("PostDaoImpl postBookmarkDelete Exception->"+e.getMessage());
		}
		return result;
	}

}
