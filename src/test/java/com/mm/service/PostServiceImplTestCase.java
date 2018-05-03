package com.mm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.mm.model.PostDto;
import com.mm.storage.AppCommonRepositoryFakeImpl;
import com.mm.storage.AppRepository;
import com.mm.storage.PostDao;


public class PostServiceImplTestCase {
	
	private static final String AUTHOR1_MOCKED = "author1";
	private static final String AUTHOR2_MOCKED = "author2";
	
	//mock posts of author1
	private PostDao postDaoMock1 = new PostDao("message1", AUTHOR1_MOCKED);
	private PostDao postDaoMock2 = new PostDao("message2", AUTHOR1_MOCKED);
	private List<PostDao> mockedPostsDaoAuthor1 = new ArrayList<PostDao>();
	
	//mock posts of author2
	private PostDao postDaoMock3 = new PostDao("message3", AUTHOR2_MOCKED);
	private PostDao postDaoMock4 = new PostDao("message4", AUTHOR2_MOCKED);
	private List<PostDao> mockedPostsDaoAuthor2 = new ArrayList<PostDao>();
	
	@Mock
	private AppRepository appFakeRepoService = new AppCommonRepositoryFakeImpl();
	
	@InjectMocks
	@Autowired
	private PostsServiceImpl postsService;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		//mock posts for author 1
		mockedPostsDaoAuthor1.add(postDaoMock1);
		mockedPostsDaoAuthor1.add(postDaoMock2);
		Mockito.when(appFakeRepoService.getAuthorPosts(AUTHOR1_MOCKED)).thenReturn(mockedPostsDaoAuthor1);
		
		//mock posts for author 2
		mockedPostsDaoAuthor2.add(postDaoMock3);
		mockedPostsDaoAuthor2.add(postDaoMock4);
		Mockito.when(appFakeRepoService.getAuthorPosts(AUTHOR2_MOCKED)).thenReturn(mockedPostsDaoAuthor2);
		
		//mock returning followed authors
		List<String> mockFollowedAuthors = new ArrayList<String>();
		mockFollowedAuthors.add(AUTHOR2_MOCKED);
		Mockito.when(appFakeRepoService.getFollowedAuthors(AUTHOR1_MOCKED)).thenReturn(mockFollowedAuthors);				
		
	}
	
	@Test
	public void givenPostsDaoByAuthorExpectEqualNumberOfMessages() throws Exception {
		List<PostDto> postsDto = postsService.getAuthorPosts(AUTHOR1_MOCKED);
		Assert.assertEquals(postsDto.size(), mockedPostsDaoAuthor1.size());
	}
	
	@Test
	public void givenPostsDaoByAuthorExpectMessagesReturnedInReverseOrder() throws Exception {
		List<PostDto> postsDto = postsService.getAuthorPosts(AUTHOR1_MOCKED);
		Assert.assertEquals(postsDto.get(0).getAuthor(), mockedPostsDaoAuthor1.get(1).getAuthor());
		Assert.assertEquals(postsDto.get(0).getMessage(), mockedPostsDaoAuthor1.get(1).getMessage());
	}
	
	@Test
	public void givenPostsDaoAllExpectMessagesByAuthorAndByFollowedAuthor() throws Exception {
		List<PostDto> postsDto = postsService.getAllPosts(AUTHOR1_MOCKED);
		Assert.assertEquals(postsDto.size(), (mockedPostsDaoAuthor1.size() + mockedPostsDaoAuthor2.size()));
	}
	
}
