﻿using AndroidStudioWebApi.Data.Entities;
using Microsoft.EntityFrameworkCore;

namespace AndroidStudioWebApi.Data
{
    public class AppEFContext : DbContext
    {
        public AppEFContext(DbContextOptions<AppEFContext> options)
            : base(options) { }

        public DbSet<CategoryEntity> Categories { get; set; }
    }
}
