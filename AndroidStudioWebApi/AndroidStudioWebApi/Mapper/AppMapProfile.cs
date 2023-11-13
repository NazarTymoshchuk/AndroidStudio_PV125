using AutoMapper;
using AndroidStudioWebApi.Data.Entities;
using AndroidStudioWebApi.Models.Category;

namespace AndroidStudioWebApi.Mapper
{
    public class AppMapProfile : Profile
    {
        public AppMapProfile()
        {
            CreateMap<CategoryEntity, CategoryItemViewModel>();
            CreateMap<CategoryCreateViewModel, CategoryEntity>();
        }
    }
}
