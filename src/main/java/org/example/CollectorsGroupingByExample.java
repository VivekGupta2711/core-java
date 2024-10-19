package org.example;

import org.example.model.BlogPost;
import org.example.model.BlogPostType;
import org.example.model.PostCountTitlesLikesStats;
import org.example.model.Tuple;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsGroupingByExample {

    public static void main(String[] args) {
        BlogPost blogPostGuide = new BlogPost("JavaCollection", "Vivek", BlogPostType.GUIDE, 1);
        BlogPost blogPostNews = new BlogPost("CricketNews", "Alex", BlogPostType.NEWS, 100);
        BlogPost blogPostAlexTravel = new BlogPost("TRAVEL", "Alex", BlogPostType.GUIDE, 34);
        BlogPost blogPostAlexCurryWorld = new BlogPost("CURYYWORLD", "Alex", BlogPostType.REVIEW, 12);
        BlogPost blogPostReview = new BlogPost("Amazon", "Mat", BlogPostType.REVIEW, 1000);

        List<BlogPost> blogPosts = List.of(blogPostGuide, blogPostNews, blogPostReview, blogPostAlexTravel, blogPostAlexCurryWorld);

//        System.out.println("groupingBySingleColumn\n" + groupingBySingleColumn(blogPosts));

//        System.out.println("groupingBySingleColumnWithKeyAsAnyObject\n" + groupingBySingleColumnWithKeyAsAnyObject(blogPosts));

//        System.out.println("grpBySingleColumnWithKeyAsAnyObjectAndModifyReturnedMapValueType\n"
//                + grpBySingleColumnWithKeyAsAnyObjectAndModifyReturnedMapValueType(blogPosts));

//        System.out.println("grpByMultipleFields\n"
//                + grpByMultipleFields(blogPosts));

//        System.out.println("gettingAverageFromGroupedResults\n"
//                + gettingAverageFromGroupedResults(blogPosts));

//        System.out.println("modifyingTheReturnMapType\n"
//                + modifyingTheReturnMapType(blogPosts));

                System.out.println("aggregatingMultipleAttributesOfGroupedResult\n"
                + aggregatingMultipleAttributesOfGroupedResult(blogPosts));

    }


    static Map<BlogPostType, List<BlogPost>> groupingBySingleColumn(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(BlogPost::type));
    }

    static Map<Tuple, List<BlogPost>> groupingBySingleColumnWithKeyAsAnyObject(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(blogPost -> new Tuple(blogPost.type(), blogPost.author())));
    }

    static Map<Tuple, Set<BlogPost>> grpBySingleColumnWithKeyAsAnyObjectAndModifyReturnedMapValueType(List<BlogPost> blogPosts) {
        return blogPosts.stream()
                .collect(Collectors.groupingBy(blogPost -> new Tuple(blogPost.type(), blogPost.author()),
                        Collectors.toSet()));
    }

    static Map<String, Map<BlogPostType, List<BlogPost>>> grpByMultipleFields(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(BlogPost::author, Collectors.groupingBy(BlogPost::type)));
    }

    static Map<BlogPostType, Double> gettingAverageFromGroupedResults(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(BlogPost::type, Collectors.averagingInt(BlogPost::likes)));
    }

    static EnumMap<BlogPostType, List<BlogPost>> modifyingTheReturnMapType(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(BlogPost::type, () -> new EnumMap<>(BlogPostType.class),
                Collectors.toList()));
    }

    static Map<String, PostCountTitlesLikesStats> aggregatingMultipleAttributesOfGroupedResult(List<BlogPost> blogPosts) {
        return blogPosts.stream().collect(Collectors.groupingBy(BlogPost::author,
                Collectors.collectingAndThen(Collectors.toList(), groupedBlogPosts -> {
                    long count = groupedBlogPosts.stream().count();
                    String titles = groupedBlogPosts.stream().map(BlogPost::title).collect(Collectors.joining(" : "));
                    IntSummaryStatistics intSummaryStatistics = groupedBlogPosts.stream().collect(Collectors.summarizingInt(BlogPost::likes));
                    return new PostCountTitlesLikesStats(count, titles, intSummaryStatistics);
                })
        ));
    }

}
